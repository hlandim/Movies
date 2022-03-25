package com.hlandim.movies.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hlandim.movies.data.Repository
import com.hlandim.movies.data.RepositoryResult
import com.hlandim.movies.model.MoviesResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

@HiltViewModel
class MoviesViewModel @Inject constructor(
    application: Application,
    private val repository: Repository,
    private val dispatcher: CoroutineDispatcher // Used for unit tests
) : AndroidViewModel(application) {

    private val _response: MutableLiveData<RepositoryResult<MoviesResponse>> = MutableLiveData()
    val response: LiveData<RepositoryResult<MoviesResponse>> = _response

    fun fetchMovies() {
        _response.value = RepositoryResult.Loading()
        viewModelScope.launch(dispatcher) {
            val movies = repository.getMovies()
            _response.postValue(movies)
        }
    }
}