package com.hlandim.movies.ui.list

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
fun MoviesList(movies: List<Movie>) {

    LazyVerticalGrid(
        cells = GridCells.Adaptive(128.dp),
        // content padding
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        ),
        content = {
            itemsIndexed(movies) { _, row ->
                MovieCard(movie = row)
            }
        }
    )
}

@Composable
fun MovieCard(movie: Movie) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(2.dp)
    ) {
        Column {
            GlideImage(
                imageModel = BASE_IMAGE_URL + movie.thumbnailPath,
                // Crop, Fit, Inside, FillHeight, FillWidth, None
                contentScale = ContentScale.Crop,
//            // shows an indicator while loading an image.
//            loading = {
//                Box(modifier = Modifier.matchParentSize()) {
//                    CircularProgressIndicator(
//                        modifier = Modifier.align(Alignment.Center)
//                    )
//                }
//            },
//            // shows an error text if fail to load an image.
//            failure = {
//                Text(text = "image request failed.")
//            },
                previewPlaceholder = R.drawable.ic_launcher_background
            )
            Text(
                textAlign = TextAlign.Center,
                color = Color.Black,
                text = movie.title,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Text(
                textAlign = TextAlign.Center,
                color = Color.Black,
                text = "${movie.popularity}",
                modifier = Modifier
                    .fillMaxWidth()
            )
        }


    }

}

@ExperimentalFoundationApi
@Preview(
    name = "Movies List",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true
)
@Composable
fun PreviewMoviesList() {
    val movies = listOf(
        Movie("Title 1", "/iPhDToxFzREctUA0ZQiYZamXsMy.jpg", 1.2),
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
    MoviesList(movies)
}

