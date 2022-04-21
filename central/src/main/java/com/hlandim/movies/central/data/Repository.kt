package com.hlandim.movies.central.data

import com.hlandim.movies.central.data.response.MoviesListResponse

interface Repository {

    suspend fun getMovies(page: Int): RepositoryResult<MoviesListResponse>

}