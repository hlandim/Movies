package com.hlandim.movies.data

import com.hlandim.movies.data.remote.themoviedb.MoviesResponse
import com.hlandim.movies.util.NetworkResult

interface Repository {

    suspend fun getMovies(): NetworkResult<MoviesResponse>

}