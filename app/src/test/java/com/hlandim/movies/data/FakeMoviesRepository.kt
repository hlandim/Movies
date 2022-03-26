package com.hlandim.movies.data

import com.google.gson.Gson
import com.hlandim.movies.model.Movie
import com.hlandim.movies.model.MoviesResponse
import com.hlandim.movies.util.MockResponseFileReader

class FakeMoviesRepository : Repository {

    override suspend fun getMovies(): RepositoryResult<MoviesResponse> {
        val jsonResponse = MockResponseFileReader("theMovieDbApi/list_success.json").content
        val moviesResponse = Gson().fromJson(jsonResponse, MoviesResponse::class.java)
        return RepositoryResult.Success(moviesResponse)
    }

    override suspend fun getMovieDetails(movieId: Int): RepositoryResult<Movie> {
        val jsonResponse = MockResponseFileReader("theMovieDbApi/details_success.json").content
        val movieResponse = Gson().fromJson(jsonResponse, Movie::class.java)
        return RepositoryResult.Success(movieResponse)
    }
}