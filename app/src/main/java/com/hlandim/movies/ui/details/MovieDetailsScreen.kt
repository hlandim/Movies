package com.hlandim.movies.ui.details

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.hlandim.movies.model.Movie
import com.hlandim.movies.ui.MoviesAppTheme
import com.hlandim.movies.util.Utils

@Composable
fun MovieDetailsScreen(movie: Movie) {
    MoviesAppTheme {
        Scaffold(
            content = { Init(movie = movie) }
        )
    }
}

@Composable
fun Init(movie: Movie) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {

            Text(
                modifier = Modifier.fillMaxSize(),
                color = Color.White,
                text = movie.title
            )
        }
    }
}

@ExperimentalFoundationApi
@Preview(
    name = "Movies Details Screen",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
fun PreviewMovieDetailsScreen() {
    val movie = Utils.createMovieMock("Title 1")
    MovieDetailsScreen(movie)
}