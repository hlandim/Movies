package com.hlandim.movies.data

import com.google.gson.Gson
import com.hlandim.movies.model.MoviesResponse
import com.hlandim.movies.util.MockResponseFileReader
import com.hlandim.movies.util.RepositoryResult

class FakeMoviesRepository : Repository {

    override suspend fun getMovies(): RepositoryResult<MoviesResponse> {
        val jsonResponse = MockResponseFileReader("theMovieDbApi/success.json").content
        val moviesResponse = Gson().fromJson(jsonResponse, MoviesResponse::class.java)
        return RepositoryResult.Success(moviesResponse)
    }
}