package com.hlandim.movies.movieslist.details

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hlandim.movies.central.data.response.MovieResponse
import com.hlandim.movies.common.view.componet.MovieImage
import com.hlandim.movies.ui.MoviesAppTheme
import com.hlandim.movies.common.view.R as ViewResources

@Composable
fun MovieDetailsScreen(movie: MovieResponse) {
    MoviesAppTheme {
        Scaffold(
            content = { Init(movie) }
        )
    }
}

@Composable
fun Init(movie: MovieResponse) {
    val movieState = remember { movie }
    MovieDetails(movieState)
}

@Composable
fun MovieDetails(movieDetails: MovieResponse?) {
    movieDetails?.let { movie ->
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                movie.backDropPath?.let { imgPath ->
                    MovieImage(
                        imagePath = imgPath,
                        width = "400",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                            .semantics {
                                contentDescription = "backDropPath"
                            }
                    )
                }
                Column(
                    modifier = Modifier.padding(5.dp)
                ) {
                    Row {
                        movie.posterPath?.let { imgPath ->
                            MovieImage(
                                imagePath = imgPath,
                                width = "200",
                                modifier = Modifier
                                    .height(200.dp)
                                    .width(150.dp)
                                    .semantics {
                                        contentDescription = "posterPath"
                                    }
                            )
                        }
                        Column {
                            val defaultModifier = Modifier
                                .fillMaxSize()
                                .padding(2.dp)
                            Text(
                                modifier = defaultModifier.semantics {
                                    contentDescription = "title"
                                },
                                text = movie.title,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold,
                                fontSize = 23.sp
                            )
                            Text(
                                modifier = defaultModifier.semantics {
                                    contentDescription = "popularity"
                                },
                                text = stringResource(
                                    id = ViewResources.string.popularity_label,
                                    movie.popularity
                                ),
                                textAlign = TextAlign.Center,
                                fontSize = 20.sp
                            )
                            movie.getReleaseDateYear()?.let {
                                Text(
                                    modifier = defaultModifier.semantics {
                                        contentDescription = "releaseYear"
                                    },
                                    text = stringResource(
                                        id = ViewResources.string.release_year_label,
                                        it
                                    ),
                                    textAlign = TextAlign.Center,
                                    fontSize = 20.sp,
                                )
                            }
                        }

                    }
                    movie.overview?.let {
                        Text(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(
                                    top = 15.dp,
                                    bottom = 5.dp,
                                    start = 5.dp,
                                    end = 5.dp
                                )
                                .semantics {
                                    contentDescription = "overview"
                                },
                            text = it,
                            textAlign = TextAlign.Center,
                            fontSize = 18.sp
                        )
                    }
                }

            }
        }
    }
}

@ExperimentalFoundationApi
@Preview(
    name = "Movies Details Screen",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true
)
@Composable
fun PreviewMovieDetailsScreen() {
    val movie = com.hlandim.movies.common.view.componet.util.Utils.createMovieMock("Title 1")
    MoviesAppTheme {
        MovieDetails(movie)
    }
}