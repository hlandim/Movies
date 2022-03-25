package com.hlandim.movies

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.hlandim.movies.data.FakeMoviesRepository
import com.hlandim.movies.util.MainCoroutineRule
import com.hlandim.movies.viewmodel.MoviesViewModel
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class MoviesViewModelTest {
    private val testDispatcher = TestCoroutineDispatcher()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @MockK
    lateinit var application: Application

    private lateinit var viewModel: MoviesViewModel


    @Before
    fun setup() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(mainCoroutineRule.dispatcher)

        viewModel = MoviesViewModel(application, FakeMoviesRepository(), testDispatcher)

    }

    @Test
    fun `When requesting the movies list, Then it should return the movies list`() {

        mainCoroutineRule.dispatcher.runBlockingTest {
            viewModel.fetchMovies()
            val movies = viewModel.response.value?.data
            Assert.assertNotNull(movies)
        }

    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

}