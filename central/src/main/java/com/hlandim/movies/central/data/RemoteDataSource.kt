package com.hlandim.movies.central.data

import com.hlandim.movies.central.data.api.TheMovieDbService
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val theMovieDbService: TheMovieDbService) {
    suspend fun getMovies(page: Int) = theMovieDbService.getMovies(page)
}