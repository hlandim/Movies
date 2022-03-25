package com.hlandim.movies.ui.list

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hlandim.movies.model.Movie
import com.hlandim.movies.ui.componet.MovieCard
import java.util.*


@ExperimentalFoundationApi
@Composable
fun MoviesList(movies: List<Movie>, listener: (Movie) -> Unit) {

    LazyColumn(
        modifier = Modifier
            .padding(all = 10.dp)
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
        Movie(1, "Title 1", "/iPhDToxFzREctUA0ZQiYZamXsMy.jpg", 1.2, Date()),
        Movie(2, "Big Title test 123123123", "/iQFcwSGbZXMkeyKrxbPnwnRo5fl.jpg", 1.3, Date()),
        Movie(3, "Title 2", "/iQFcwSGbZXMkeyKrxbPnwnRo5fl.jpg", 1.3, Date()),
        Movie(4, "Title 3", "/ewUqXnwiRLhgmGhuksOdLgh49Ch.jpg", 1.4, Date()),
        Movie(5, "Title 4", "/2hGjmgZrS1nlsEl5PZorn7EsmzH.jpg", 1.0, Date()),
        Movie(6, "Title 5", "/2hGjmgZrS1nlsEl5PZorn7EsmzH.jpg", 1.0, Date()),
        Movie(7, "Title 6", "/2hGjmgZrS1nlsEl5PZorn7EsmzH.jpg", 1.0, Date()),
        Movie(8, "Title 7", "/2hGjmgZrS1nlsEl5PZorn7EsmzH.jpg", 1.0, Date()),
        Movie(9, "Title 8", "/2hGjmgZrS1nlsEl5PZorn7EsmzH.jpg", 1.0, Date()),
        Movie(10, "Title 9", "/2hGjmgZrS1nlsEl5PZorn7EsmzH.jpg", 1.0, Date()),
        Movie(11, "Title 10", "/j2zyoYrWjWyraHMdkqAkSG1MISJ.jpg", 1.9, Date())
    )
    MoviesList(movies) {

    }
}

