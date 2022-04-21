package com.hlandim.movies.movieslist.data

import com.google.gson.Gson
import com.hlandim.movies.central.data.Repository
import com.hlandim.movies.central.data.RepositoryResult
import java.io.InputStreamReader

class FakeMoviesRepository : Repository {

    private val jsonResponse: String

    init {
        val reader =
            InputStreamReader(this.javaClass.classLoader!!.getResourceAsStream("theMovieDbApi/list_success.json"))
        jsonResponse = reader.readText()
        reader.close()
    }

    override suspend fun getMovies(page: Int): RepositoryResult<com.hlandim.movies.common.data.MoviesList> {
        val moviesResponse = Gson().fromJson(
            jsonResponse,
            com.hlandim.movies.common.data.MoviesList::class.java
        )
        return RepositoryResult.Success(moviesResponse)
    }
}