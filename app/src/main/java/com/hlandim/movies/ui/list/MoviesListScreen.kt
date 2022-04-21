package com.hlandim.movies.ui.list

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.hlandim.movies.R
import com.hlandim.movies.central.data.response.MovieResponse
import com.hlandim.movies.ui.MoviesAppTheme
import com.hlandim.movies.ui.componet.ErrorMsg
import com.hlandim.movies.ui.componet.LoadingMsg
import com.hlandim.movies.ui.componet.MessageText
import com.hlandim.movies.ui.componet.MoviesList
import com.hlandim.movies.util.Utils
import com.hlandim.movies.viewmodel.MoviesViewModel

@ExperimentalFoundationApi
@Composable
fun MoviesListScreen(moviesViewModel: MoviesViewModel, onMovieSelectedListener: (MovieResponse) -> Unit) {
    MoviesAppTheme {
        val loadingState by moviesViewModel.loading.observeAsState()
        Column {
            val moviesList by moviesViewModel.moviesList.observeAsState()
            InitList(moviesList, loadingState, onMovieSelectedListener) {
                moviesViewModel.fetchNextPage()
            }
            LoadingMsg(loadingState)
        }
        val errorMsg by moviesViewModel.errorMsg.observeAsState()
        ListErrorMsg(errorMsg, loadingState)

    }
}

@Composable
@ExperimentalFoundationApi
fun InitList(
    moviesList: List<MovieResponse>?,
    loadingState: Boolean?,
    onMovieSelectedListener: (MovieResponse) -> Unit,
    onListEnded: () -> Unit
) {
    loadingState?.let { isLoading ->
        if (moviesList != null) {
            Column {
                Box() {
                    MoviesList(moviesList, onMovieSelectedListener, onListEnded)
                    Box(
                        Modifier
                            .fillMaxHeight()
                            .align(Alignment.BottomEnd)) {
                        if (isLoading) {
                            Box(Modifier.align(Alignment.BottomEnd)) {
                                LoadingMsg(loadingState)
                            }
                        }
                    }
                }
            }
        } else {
            if (!isLoading) {
                MessageText(stringResource(id = R.string.no_movies_found))
            }
        }
    }
}

@Composable
fun ListErrorMsg(errorMsg: String?, loadingState: Boolean?) {
    loadingState?.let {
        if (!it) {
            ErrorMsg(errorMsg)
        }
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
    val movies = mutableListOf(
        Utils.createMovieMock("Title 1"),
        Utils.createMovieMock("Big Title test 123123123"),
        Utils.createMovieMock("Title 6")
    )
    InitList(movies, true, {}) {

    }
}