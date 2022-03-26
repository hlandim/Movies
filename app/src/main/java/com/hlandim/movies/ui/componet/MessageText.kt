package com.hlandim.movies.ui.componet

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.hlandim.movies.R

@Composable
fun AppMessageText(message: String?) {
    val finalMsg = message ?: stringResource(id = R.string.general_error_msg)
    Text(
        text = finalMsg,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
    )
}