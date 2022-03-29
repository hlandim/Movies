package com.hlandim.movies.ui.details

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hlandim.movies.R
import com.hlandim.movies.model.Movie
import com.hlandim.movies.ui.MoviesAppTheme
import com.hlandim.movies.util.Constants
import com.hlandim.movies.util.Utils
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun MovieDetailsScreen(movie: Movie) {
    MoviesAppTheme {
        Scaffold(
            content = { Init(movie) }
        )
    }
}

@Composable
fun Init(movie: Movie) {
    val movieState = remember { movie }
    MovieDetails(movieState)
}

@Composable
fun MovieDetails(movieDetails: Movie?) {
    movieDetails?.let { movie ->
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                GlideImage(
                    imageModel = "${Constants.BASE_IMAGE_URL}w400${movie.backDropPath}",
                    // Crop, Fit, Inside, FillHeight, FillWidth, None
                    contentScale = ContentScale.FillWidth,
                    // shows an image with the circular reveal animation.
                    circularReveal = CircularReveal(duration = 350),
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
                        .fillMaxWidth()
                        .height(180.dp)
                        .semantics {
                            contentDescription = "backDropPath"
                        }
                )
                Column(
                    modifier = Modifier.padding(5.dp)
                ) {
                    Row {
                        GlideImage(
                            imageModel = "${Constants.BASE_IMAGE_URL}w200${movie.posterPath}",
                            // Crop, Fit, Inside, FillHeight, FillWidth, None
                            contentScale = ContentScale.FillWidth,
                            // shows an image with the circular reveal animation.
                            circularReveal = CircularReveal(duration = 350),
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
                                .height(200.dp)
                                .width(150.dp)
                                .semantics {
                                    contentDescription = "posterPath"
                                }
                        )
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
                                    id = R.string.popularity_label,
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
                                    text = stringResource(id = R.string.release_year_label, it),
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
    val movie = Utils.createMovieMock("Title 1")
    MoviesAppTheme {
        MovieDetails(movie)
    }
}