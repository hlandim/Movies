package com.hlandim.movies.data

import com.hlandim.movies.data.remote.themoviedb.MoviesResponse
import com.hlandim.movies.data.remote.RemoteDataSource
import com.hlandim.movies.util.NetworkResult
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class RepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : BaseApiResponse(), Repository {
    override suspend fun getMovies(): NetworkResult<MoviesResponse> {
        return safeApiCall {
            remoteDataSource.getMovies()
        }
    }
}