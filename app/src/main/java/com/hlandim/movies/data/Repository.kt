package com.hlandim.movies.data

import com.hlandim.movies.model.MoviesResponse
import com.hlandim.movies.util.RepositoryResult

interface Repository {

    suspend fun getMovies(): RepositoryResult<MoviesResponse>

}