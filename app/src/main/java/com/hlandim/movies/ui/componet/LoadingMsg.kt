package com.hlandim.movies.ui.componet

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.hlandim.movies.R

@Composable
fun LoadingMsg(loadingState: Boolean?) {
    loadingState?.let {
        if (it) {
            MessageText(stringResource(R.string.loading_msg))
        }
    }
}