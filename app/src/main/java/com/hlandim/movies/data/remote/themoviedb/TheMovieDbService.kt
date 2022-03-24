package com.hlandim.movies.data.remote.themoviedb

import retrofit2.Response
import retrofit2.http.GET

interface TheMovieDbService {
    @GET("/movie/popular")
    suspend fun getMovies(): Response<MoviesResponse>
}