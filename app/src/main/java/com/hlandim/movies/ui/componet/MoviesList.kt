package com.hlandim.movies.ui.list

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hlandim.movies.R
import com.hlandim.movies.model.Movie
import com.hlandim.movies.util.Constants.Companion.BASE_IMAGE_URL
import com.skydoves.landscapist.glide.GlideImage


@ExperimentalFoundationApi
@Composable
fun MoviesList(movies: List<Movie>, listener: (Movie) -> Unit) {

    LazyVerticalGrid(
        cells = GridCells.Adaptive(128.dp),
        modifier = Modifier
            .wrapContentWidth()
            .fillMaxHeight(),
//        // content padding
//        contentPadding = PaddingValues(
//            start = 12.dp,
//            top = 16.dp,
//            end = 12.dp,
//            bottom = 16.dp
//        ),
        content = {
            itemsIndexed(movies) { _, row ->
                MovieCard(movie = row, listener)
            }
        }
    )
}

@Composable
fun MovieCard(movie: Movie, listener: (Movie) -> Unit) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(4.dp)
            .defaultMinSize(
                minHeight = 150.dp
            ).clickable {
                listener(movie)
            }
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            GlideImage(
                imageModel = BASE_IMAGE_URL + movie.thumbnailPath,
                // Crop, Fit, Inside, FillHeight, FillWidth, None
                contentScale = ContentScale.Crop,
                // shows an indicator while loading an image.
                loading = {
                    Box(modifier = Modifier.matchParentSize()) {
                        CircularProgressIndicator(
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                },
                // shows an error text if fail to load an image.
                failure = {
                    Text(text = "image request failed.")
                },
                // Used by Compose compile when using preview tab
                previewPlaceholder = R.drawable.ic_launcher_background
            )
            Text(
                textAlign = TextAlign.Center,
                text = movie.title,
                modifier = Modifier
                    .fillMaxSize()
                    .fillMaxHeight()
            )
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
    MoviesList(movies) {

    }
}

