package com.hlandim.movies.central.data

import com.hlandim.movies.central.data.response.BaseApiResponse
import com.hlandim.movies.central.data.response.MoviesListResponse
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class RepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : BaseApiResponse(), Repository {
    override suspend fun getMovies(page: Int): RepositoryResult<MoviesListResponse> {
        return safeApiCall {
            remoteDataSource.getMovies(page)
        }
    }
}