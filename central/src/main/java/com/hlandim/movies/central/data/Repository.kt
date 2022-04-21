package com.hlandim.movies.central.data

import com.hlandim.movies.common.data.MoviesList

interface Repository {

    suspend fun getMovies(page: Int): RepositoryResult<MoviesList>

}