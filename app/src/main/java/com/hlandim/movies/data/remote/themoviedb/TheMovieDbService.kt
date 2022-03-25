package com.hlandim.movies.data.remote.themoviedb

import com.hlandim.movies.model.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET

interface TheMovieDbService {
    @GET("movie/popular")
    suspend fun getMovies(): Response<MoviesResponse>
}