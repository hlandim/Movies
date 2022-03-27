package com.hlandim.movies.model

import com.google.gson.annotations.SerializedName

data class MoviesResponse(
    val page: Int,
    var results: MutableList<Movie>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)