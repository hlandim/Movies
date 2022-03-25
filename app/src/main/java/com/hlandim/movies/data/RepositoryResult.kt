package com.hlandim.movies.data

sealed class RepositoryResult<T>(
    val data: T? = null,
    val message: String? = null
) {

    class Success<T>(data: T) : RepositoryResult<T>(data)

    class Error<T>(message: String, data: T? = null) : RepositoryResult<T>(data, message)

    class Loading<T> : RepositoryResult<T>()

}