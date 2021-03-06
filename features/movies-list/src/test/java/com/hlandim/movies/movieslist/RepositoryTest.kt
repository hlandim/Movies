package com.hlandim.movies.movieslist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.hlandim.movies.central.data.api.TheMovieDbService
import com.hlandim.movies.central.data.RemoteDataSource
import com.hlandim.movies.central.data.RepositoryImpl
import com.hlandim.movies.movieslist.util.MockResponseFileReader
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
class RepositoryTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()
    private val server = MockWebServer()
    private lateinit var repository: RepositoryImpl
    private lateinit var mockResponse: String

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
    fun `When calling the requesting the movie list the repository should return the movie list`() {
        mockResponse = MockResponseFileReader("theMovieDbApi/list_success.json").content

        server.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(mockResponse)
        )

        val response = runBlocking { repository.getMovies(1) }

        Assert.assertNotNull(response)
        Assert.assertTrue(response is com.hlandim.movies.central.data.RepositoryResult.Success)
        Assert.assertNotNull(response.data)
        Assert.assertEquals(1, response.data!!.page)
        Assert.assertEquals(20, response.data!!.results.size)
    }

    @Test
    fun `When using a wrong auth, then the repository should return an error`() {

        server.enqueue(
            MockResponse()
                .setResponseCode(401)
        )

        val response = runBlocking { repository.getMovies(1) }

        Assert.assertNotNull(response)
        Assert.assertTrue(response is com.hlandim.movies.central.data.RepositoryResult.Error)
        Assert.assertNull(response.data)
        Assert.assertEquals("Api call failed: 401 Client Error", response.message)
    }

    @After
    fun tearDown() {
        server.shutdown()
    }

}