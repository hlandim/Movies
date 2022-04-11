package com.hlandim.movies.central.data.api

import com.hlandim.movies.central.data.response.MovieResponse
import com.hlandim.movies.central.data.response.MoviesListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TheMovieDbService {
    @GET("movie/popular")
    suspend fun getMovies(@Query("page") page: Int): Response<MoviesListResponse>

    @GET("movie/{movieId}")
    suspend fun getMovieDetails(
        @Path("movieId")
        movieId: Int
    ): Response<MovieResponse>
}