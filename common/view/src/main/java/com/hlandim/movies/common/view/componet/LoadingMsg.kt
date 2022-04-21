package com.hlandim.movies.common.view.componet

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.hlandim.movies.common.view.R

@Composable
fun LoadingMsg(loadingState: Boolean?) {
    loadingState?.let {
        if (it) {
            MessageText(stringResource(R.string.loading_msg))
        }
    }
}