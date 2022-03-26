package com.hlandim.movies.data

import com.hlandim.movies.data.remote.BaseApiResponse
import com.hlandim.movies.data.remote.RemoteDataSource
import com.hlandim.movies.model.Movie
import com.hlandim.movies.model.MoviesResponse
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class RepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : BaseApiResponse(), Repository {
    override suspend fun getMovies(): RepositoryResult<MoviesResponse> {
        return safeApiCall {
            remoteDataSource.getMovies()
        }
    }

    override suspend fun getMovieDetails(movieId: Int): RepositoryResult<Movie> {
        return safeApiCall {
            remoteDataSource.getMovieDetails(movieId)
        }
    }
}