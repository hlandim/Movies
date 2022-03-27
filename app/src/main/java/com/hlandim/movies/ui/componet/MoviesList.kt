package com.hlandim.movies.ui.componet

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hlandim.movies.model.Movie
import com.hlandim.movies.util.Utils


@ExperimentalFoundationApi
@Composable
fun MoviesList(movies: List<Movie>, listener: (Movie) -> Unit) {

    LazyColumn(
        modifier = Modifier
            .padding(all = 10.dp)
            .semantics {
                contentDescription = "MovieList"
            }
    ) {
        itemsIndexed(movies) { _, movie ->
            MovieCard(movie = movie, listener)
        }
    }
}

@ExperimentalFoundationApi
@Preview(
    name = "Movies List",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
fun PreviewMoviesList() {
    val movies = listOf(
        Utils.createMovieMock("Title 1"),
        Utils.createMovieMock("Big Title test 123123123"),
        Utils.createMovieMock("Title 2"),
        Utils.createMovieMock("Title 3"),
        Utils.createMovieMock("Title 4"),
        Utils.createMovieMock("Title 5"),
        Utils.createMovieMock("Title 6")
    )
    MoviesList(movies) {

    }
}

