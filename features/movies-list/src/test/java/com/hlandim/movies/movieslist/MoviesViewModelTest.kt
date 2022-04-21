package com.hlandim.movies.movieslist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.hlandim.movies.movieslist.data.FakeMoviesRepository
import io.mockk.MockKAnnotations
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestCoroutineScheduler
import kotlinx.coroutines.test.resetMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class MoviesViewModelTest {
    private val scheduler = TestCoroutineScheduler()
    private val testDispatcher = StandardTestDispatcher(scheduler)

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MoviesViewModel


    @Before
    fun setup() {
        MockKAnnotations.init(this)

        viewModel = MoviesViewModel(FakeMoviesRepository(), testDispatcher)

    }

    @Test
    fun `When requesting the movies list, Then it should return the movies list`() {
        viewModel.fetchNextPage()
        scheduler.advanceUntilIdle()
        val movies = viewModel.moviesList.value
        Assert.assertNotNull(movies)
    }

    @Test
    fun `Given a selected movie, When requesting the movie details, Then it should return the movies details`() {
        //Given
        val movieMock = com.hlandim.movies.common.view.componet.util.Utils.createMovieMock("Test Movie")
        viewModel.selectedMovie(movieMock)

        //When
        val selectedMovie = viewModel.movieDetails.value

        // Then
        Assert.assertNotNull(selectedMovie)
        Assert.assertEquals(movieMock, selectedMovie)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

}