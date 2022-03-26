package com.hlandim.movies.data

import com.hlandim.movies.model.Movie
import com.hlandim.movies.model.MoviesResponse

interface Repository {

    suspend fun getMovies(): RepositoryResult<MoviesResponse>
    suspend fun getMovieDetails(movieId: Int): RepositoryResult<Movie>

}