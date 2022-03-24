package com.hlandim.movies.data.remote.themoviedb

import com.google.gson.annotations.SerializedName
import com.hlandim.movies.model.Movie

data class MoviesResponse(
    val page: Int,
    val results: List<Movie>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)