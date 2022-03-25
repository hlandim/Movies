package com.hlandim.movies.data

import com.hlandim.movies.model.MoviesResponse
import com.hlandim.movies.data.remote.RemoteDataSource
import com.hlandim.movies.util.RepositoryResult
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
}