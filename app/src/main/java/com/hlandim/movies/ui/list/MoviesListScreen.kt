package com.hlandim.movies.ui.list

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.hlandim.movies.R
import com.hlandim.movies.data.RepositoryResult
import com.hlandim.movies.model.Movie
import com.hlandim.movies.model.MoviesResponse
import com.hlandim.movies.ui.MoviesAppTheme
import com.hlandim.movies.util.exhaustive
import com.hlandim.movies.viewmodel.MoviesViewModel

@ExperimentalFoundationApi
@Composable
fun MoviesListScreen(moviesViewModel: MoviesViewModel, listener: (Movie) -> Unit) {
    MoviesAppTheme {
        val repositoryResult by moviesViewModel.response.observeAsState()
        Init(repositoryResult, listener)
    }
}

@Composable
@ExperimentalFoundationApi
fun Init(repositoryResult: RepositoryResult<MoviesResponse>?, listener: (Movie) -> Unit) {
    repositoryResult?.let { result ->
        when (result) {
            is RepositoryResult.Error -> {
                ShowMsg(result.message)
            }
            is RepositoryResult.Loading -> {
                LoadingMessage()
            }
            is RepositoryResult.Success -> {
                if (result.data != null) {
                    MoviesList(result.data.results.sortedByDescending { it.popularity }, listener)
                } else {
                    ShowMsg(stringResource(id = R.string.no_movies_found))
                }
            }
        }.exhaustive
    }
}

@Composable
fun ShowMsg(message: String?) {
    val finalMsg = message ?: stringResource(id = R.string.general_error_msg)
    Text(
        text = finalMsg,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
    )
}

@Composable
fun LoadingMessage() {
    val finalMsg = stringResource(id = R.string.loading_msg)
    Text(
        text = finalMsg,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
    )
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
        Movie("Title 1", "/iPhDToxFzREctUA0ZQiYZamXsMy.jpg", 1.2),
        Movie("Big Title test 123123123", "/iQFcwSGbZXMkeyKrxbPnwnRo5fl.jpg", 1.3),
        Movie("Title 2", "/iQFcwSGbZXMkeyKrxbPnwnRo5fl.jpg", 1.3),
        Movie("Title 3", "/ewUqXnwiRLhgmGhuksOdLgh49Ch.jpg", 1.4),
        Movie("Title 4", "/2hGjmgZrS1nlsEl5PZorn7EsmzH.jpg", 1.0),
        Movie("Title 5", "/2hGjmgZrS1nlsEl5PZorn7EsmzH.jpg", 1.0),
        Movie("Title 6", "/2hGjmgZrS1nlsEl5PZorn7EsmzH.jpg", 1.0),
        Movie("Title 7", "/2hGjmgZrS1nlsEl5PZorn7EsmzH.jpg", 1.0),
        Movie("Title 8", "/2hGjmgZrS1nlsEl5PZorn7EsmzH.jpg", 1.0),
        Movie("Title 9", "/2hGjmgZrS1nlsEl5PZorn7EsmzH.jpg", 1.0),
        Movie("Title 10", "/j2zyoYrWjWyraHMdkqAkSG1MISJ.jpg", 1.9)
    )
    val result = RepositoryResult.Success(MoviesResponse(1, movies, 1, movies.size))
    Init(result) {

    }
}