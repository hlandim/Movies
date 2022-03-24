package com.hlandim.movies.data.remote

import com.hlandim.movies.data.remote.themoviedb.TheMovieDbService
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val theMovieDbService: TheMovieDbService) {
    suspend fun getMovies() = theMovieDbService.getMovies()
}