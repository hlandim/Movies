package com.hlandim.movies.common.view.componet

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.hlandim.movies.ui.MoviesAppTheme


@Composable
fun MessageText(message: String) {
    MoviesAppTheme {
        Surface {
            Text(
                text = message,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}

@Preview(
    name = "Message text",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
fun Preview() {
    MessageText("Testing")
}