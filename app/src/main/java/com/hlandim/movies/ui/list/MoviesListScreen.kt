package com.hlandim.movies.ui.list

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.res.stringResource
import com.hlandim.movies.R
import com.hlandim.movies.data.RepositoryResult
import com.hlandim.movies.util.exhaustive
import com.hlandim.movies.viewmodel.MoviesViewModel

@ExperimentalFoundationApi
@Composable
fun MoviesListScreen(moviesViewModel: MoviesViewModel) {
    val repositoryResult by moviesViewModel.response.observeAsState()

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
                    MoviesList(result.data.results)
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
    Text(text = finalMsg)
}

@Composable
fun LoadingMessage() {
    val finalMsg = stringResource(id = R.string.loading_msg)
    Text(text = finalMsg)
}