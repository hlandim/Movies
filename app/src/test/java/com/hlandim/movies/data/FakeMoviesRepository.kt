package com.hlandim.movies.data

import com.google.gson.Gson
import com.hlandim.movies.central.util.MockResponseFileReader

class FakeMoviesRepository : com.hlandim.movies.central.data.Repository {

    override suspend fun getMovies(page: Int): com.hlandim.movies.central.data.RepositoryResult<com.hlandim.movies.central.data.response.MoviesListResponse> {
        val jsonResponse = MockResponseFileReader("theMovieDbApi/list_success.json").content
        val moviesResponse = Gson().fromJson(jsonResponse, com.hlandim.movies.central.data.response.MoviesListResponse::class.java)
        return com.hlandim.movies.central.data.RepositoryResult.Success(moviesResponse)
    }
}