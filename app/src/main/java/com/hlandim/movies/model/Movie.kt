package com.hlandim.movies.model

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("original_title")
    val title: String,

    @SerializedName("backdrop_path")
    val thumbnailPath: String?,

    val popularity: Double
)