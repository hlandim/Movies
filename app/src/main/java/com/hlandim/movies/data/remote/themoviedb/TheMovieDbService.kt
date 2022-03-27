package com.hlandim.movies.data.remote.themoviedb

import com.hlandim.movies.model.Movie
import com.hlandim.movies.model.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TheMovieDbService {
    @GET("movie/popular")
    suspend fun getMovies(@Query("page") page: Int): Response<MoviesResponse>

    @GET("movie/{movieId}")
    suspend fun getMovieDetails(
        @Path("movieId")
        movieId: Int
    ): Response<Movie>
}