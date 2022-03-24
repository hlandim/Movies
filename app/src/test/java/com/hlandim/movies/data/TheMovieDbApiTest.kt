package com.hlandim.movies.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.gson.GsonBuilder
import com.hlandim.movies.data.remote.RemoteDataSource
import com.hlandim.movies.data.remote.themoviedb.TheMovieDbService
import com.hlandim.movies.util.MockResponseFileReader
import com.hlandim.movies.util.NetworkResult
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@RunWith(JUnit4::class)
class TheMovieDbApiTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()
    private val server = MockWebServer()
    private lateinit var repository: RepositoryImpl
    private lateinit var mockResponse: String
    private val gson = GsonBuilder()
        .create()

    @Before
    fun setup() {
        server.start(8000)

        val baseUrl = server.url("/").toString()

        val okHttpClient = OkHttpClient
            .Builder()
            .build()
        val service = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .baseUrl(baseUrl)
            .build()
            .create(TheMovieDbService::class.java)

        val dataSource = RemoteDataSource(service)

        repository = RepositoryImpl(dataSource)

    }

    @Test
    fun testApiSuccess() {
        mockResponse = MockResponseFileReader("theMovieDbApi/success.json").content

        server.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(mockResponse)
        )

        val response = runBlocking { repository.getMovies() }

        Assert.assertNotNull(response)
        Assert.assertTrue(response is NetworkResult.Success)
        Assert.assertNotNull(response.data)
        Assert.assertEquals(1, response.data!!.page)
        Assert.assertEquals(20, response.data!!.results.size)
    }

    @Test
    fun test401Error() {

        server.enqueue(
            MockResponse()
                .setResponseCode(401)
        )

        val response = runBlocking { repository.getMovies() }

        Assert.assertNotNull(response)
        Assert.assertTrue(response is NetworkResult.Error)
        Assert.assertNull(response.data)
        Assert.assertEquals("Api call failed: 401 Client Error" ,response.message)
    }

    @After
    fun tearDown() {
        server.shutdown()
    }

}