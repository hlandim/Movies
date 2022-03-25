package com.hlandim.movies.data.remote

import com.hlandim.movies.data.RepositoryResult
import retrofit2.Response

abstract class BaseApiResponse {
    suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): RepositoryResult<T> {
        try {
            val response = apiCall()
            if (response.isSuccessful) {
                val body = response.body()
                body?.let {
                    return RepositoryResult.Success(body)
                }
            }
            return error("${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(errorMessage: String): RepositoryResult<T> =
        RepositoryResult.Error("Api call failed: $errorMessage")
}