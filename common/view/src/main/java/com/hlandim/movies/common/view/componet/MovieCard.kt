package com.hlandim.movies.common.view.componet

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hlandim.movies.central.data.response.MovieResponse
import com.hlandim.movies.common.view.R
import com.hlandim.movies.common.view.componet.util.Utils


@Composable
fun MovieCard(movie: MovieResponse, listener: (MovieResponse) -> Unit) {
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
            movie.posterPath?.let { imgPath ->
                MovieImage(
                    imagePath = imgPath,
                    width = "200",
                    modifier = Modifier
                        .height(150.dp)
                        .width(100.dp)
                )
            }
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
                movie.getReleaseDateYear()?.let {
                    Text(
                        text = stringResource(id = R.string.release_year_label, it),
                        fontSize = 20.sp,
                    )

                }
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
    val movie = Utils.createMovieMock("Title 1")
    MovieCard(movie) {

    }
}