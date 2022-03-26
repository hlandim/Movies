package com.hlandim.movies.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hlandim.movies.data.Repository
import com.hlandim.movies.data.RepositoryResult
import com.hlandim.movies.model.Movie
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

    private val _moviesList: MutableLiveData<RepositoryResult<MoviesResponse>> = MutableLiveData()
    val moviesList: LiveData<RepositoryResult<MoviesResponse>> = _moviesList

    private val _movieDetails: MutableLiveData<RepositoryResult<Movie>> = MutableLiveData()
    val movieDetails: LiveData<RepositoryResult<Movie>> = _movieDetails

    init {
        fetchMovies()
    }

    fun fetchMovies() {
        _moviesList.value = RepositoryResult.Loading()
        viewModelScope.launch(dispatcher) {
            val movies = repository.getMovies()
            _moviesList.postValue(movies)
        }
    }

    fun getMovieDetails(movieId: Int) {
        _movieDetails.value = RepositoryResult.Loading()
        viewModelScope.launch(dispatcher) {
            val details = repository.getMovieDetails(movieId)
            _movieDetails.postValue(details)
        }
    }
}