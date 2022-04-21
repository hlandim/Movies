package com.hlandim.movies.central.data.api

import com.hlandim.movies.common.data.Movie
import com.hlandim.movies.common.data.MoviesList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TheMovieDbService {
    @GET("movie/popular")
    suspend fun getMovies(@Query("page") page: Int): Response<MoviesList>

    @GET("movie/{movieId}")
    suspend fun getMovieDetails(
        @Path("movieId")
        movieId: Int
    ): Response<Movie>
}