package com.hlandim.movies.data

import com.hlandim.movies.model.MoviesResponse

interface Repository {

    suspend fun getMovies(page: Int): RepositoryResult<MoviesResponse>

}