package com.hlandim.movies.ui.componet

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hlandim.movies.R
import com.hlandim.movies.model.Movie
import com.hlandim.movies.util.Constants
import com.skydoves.landscapist.glide.GlideImage
import java.util.*


@Composable
fun MovieCard(movie: Movie, listener: (Movie) -> Unit) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .clickable {
                listener(movie)
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            GlideImage(
                imageModel = Constants.BASE_IMAGE_URL + movie.thumbnailPath,
                // Crop, Fit, Inside, FillHeight, FillWidth, None
                contentScale = ContentScale.Fit,
                // draw a resized image.
//                success = { imageState ->
//                    imageState.drawable?.let {
//                        Image(
//                            bitmap = it,
//                            modifier = Modifier.size(128.dp)
//                        )
//                    }
//                },
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
                previewPlaceholder = R.drawable.ic_launcher_background,
                modifier = Modifier
                    .height(150.dp)
                    .width(100.dp)
            )
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .padding(
                        start = 6.dp,
                        end = 4.dp
                    )
                    .fillMaxWidth()
                    .fillMaxWidth()
            ) {
                Text(
                    text = movie.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 23.sp,
                    maxLines = 2
                )

                Text(
                    text = stringResource(id = R.string.popularity_label, movie.popularity),
                    fontSize = 20.sp
                )

                Text(
                    text = stringResource(
                        id = R.string.release_year_label,
                        movie.getReleaseDateYear()
                    ),
                    fontSize = 20.sp,
                )
            }

        }
    }
}

@ExperimentalFoundationApi
@Preview(
    name = "Movies Card",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
fun PreviewMovieCard() {
    val movie = Movie(1, "Title 1", "/iPhDToxFzREctUA0ZQiYZamXsMy.jpg", 1.2, Date())
    MovieCard(movie) {

    }
}