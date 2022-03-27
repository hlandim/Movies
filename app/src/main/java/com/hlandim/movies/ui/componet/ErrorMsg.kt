package com.hlandim.movies.ui.componet

import androidx.compose.runtime.Composable

@Composable
fun ErrorMsg(errorMsg: String?) {
    errorMsg?.let {
        MessageText(it)
    }
}