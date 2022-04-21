package com.hlandim.movies.common.view.componet

import androidx.compose.runtime.Composable

@Composable
fun ErrorMsg(errorMsg: String?) {
    errorMsg?.let {
        MessageText(it)
    }
}