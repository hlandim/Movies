package com.hlandim.movies.ui.componet

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.hlandim.movies.R
import com.hlandim.movies.central.BuildConfig
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun MovieImage(imagePath: String, width: String, modifier: Modifier) {

    GlideImage(
        imageModel = "${BuildConfig.API_IMG_BASE_URL}w${width}${imagePath}",
        // Crop, Fit, Inside, FillHeight, FillWidth, None
        contentScale = ContentScale.Fit,
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
        modifier = modifier
    )
}