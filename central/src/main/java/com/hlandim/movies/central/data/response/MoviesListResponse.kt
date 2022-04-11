package com.hlandim.movies.central.data.response

import com.google.gson.annotations.SerializedName

data class MoviesListResponse(
    val page: Int,
    var results: MutableList<MovieResponse>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)