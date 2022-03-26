package com.hlandim.movies.data.remote.themoviedb

import com.hlandim.movies.model.Movie
import com.hlandim.movies.model.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TheMovieDbService {
    @GET("movie/popular")
    suspend fun getMovies(): Response<MoviesResponse>

    @GET("movie/{movieId}")
    suspend fun getMovieDetails(
        @Path("movieId")
        movieId: Int
    ): Response<Movie>
}