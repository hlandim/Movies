package com.hlandim.movies.ui.list

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.hlandim.movies.R
import com.hlandim.movies.data.RepositoryResult
import com.hlandim.movies.model.Movie
import com.hlandim.movies.model.MoviesResponse
import com.hlandim.movies.ui.MoviesAppTheme
import com.hlandim.movies.ui.componet.AppMessageText
import com.hlandim.movies.ui.componet.LoadingMessageText
import com.hlandim.movies.ui.componet.MoviesList
import com.hlandim.movies.util.Utils
import com.hlandim.movies.util.exhaustive
import com.hlandim.movies.viewmodel.MoviesViewModel

@ExperimentalFoundationApi
@Composable
fun MoviesListScreen(moviesViewModel: MoviesViewModel, listener: (Movie) -> Unit) {
    MoviesAppTheme {
        val repositoryResult by moviesViewModel.moviesList.observeAsState()
        Init(repositoryResult, listener)
    }
}

@Composable
@ExperimentalFoundationApi
fun Init(repositoryResult: RepositoryResult<MoviesResponse>?, listener: (Movie) -> Unit) {
    repositoryResult?.let { result ->
        when (result) {
            is RepositoryResult.Error -> {
                AppMessageText(result.message)
            }
            is RepositoryResult.Loading -> {
                LoadingMessageText()
            }
            is RepositoryResult.Success -> {
                if (result.data != null) {
                    MoviesList(result.data.results.sortedByDescending { it.popularity }, listener)
                } else {
                    AppMessageText(stringResource(id = R.string.no_movies_found))
                }
            }
        }.exhaustive
    }
}

@ExperimentalFoundationApi
@Preview(
    name = "Movies List Screen",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
fun PreviewMoviesListScreen() {
    val movies = listOf(
        Utils.createMovieMock("Title 1"),
        Utils.createMovieMock("Big Title test 123123123"),
        Utils.createMovieMock("Title 2"),
        Utils.createMovieMock("Title 3"),
        Utils.createMovieMock("Title 4"),
        Utils.createMovieMock("Title 5"),
        Utils.createMovieMock("Title 6")
    )
    val result = RepositoryResult.Success(MoviesResponse(1, movies, 1, movies.size))
    Init(result) {

    }
}