package com.hlandim.movies.common.data

import com.google.gson.annotations.SerializedName

data class MoviesList(
    val page: Int,
    var results: MutableList<Movie>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)