package com.hlandim.movies.movieslist.data

import com.google.gson.Gson
import com.hlandim.movies.central.data.Repository
import com.hlandim.movies.central.data.RepositoryResult
import com.hlandim.movies.central.data.response.MoviesListResponse
import java.io.InputStreamReader

class FakeMoviesRepository : Repository {

    private val jsonResponse: String

    init {
        val reader =
            InputStreamReader(this.javaClass.classLoader!!.getResourceAsStream("theMovieDbApi/list_success.json"))
        jsonResponse = reader.readText()
        reader.close()
    }

    override suspend fun getMovies(page: Int): RepositoryResult<MoviesListResponse> {
        val moviesResponse = Gson().fromJson(
            jsonResponse,
            MoviesListResponse::class.java
        )
        return RepositoryResult.Success(moviesResponse)
    }
}