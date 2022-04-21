package com.hlandim.movies.movieslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hlandim.movies.central.data.RepositoryResult
import com.hlandim.movies.common.data.Movie
import com.hlandim.movies.central.data.Repository
import com.hlandim.movies.util.exhaustive
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val repository: Repository,
    private val dispatcher: CoroutineDispatcher // Used for unit tests
) : ViewModel() {

    private val _moviesList: MutableLiveData<MutableList<Movie>> =
        MutableLiveData()
    val moviesList: LiveData<MutableList<Movie>> = _moviesList

    private val _movieDetails: MutableLiveData<Movie> = MutableLiveData()
    val movieDetails: LiveData<Movie> = _movieDetails

    private val _loading: MutableLiveData<Boolean> =
        MutableLiveData<Boolean>().apply { value = false }
    val loading: MutableLiveData<Boolean> = _loading

    private val _errorMsg: MutableLiveData<String> = MutableLiveData()
    val errorMsg: MutableLiveData<String> = _errorMsg

    private var currentPage = 0

    init {
        fetchNextPage()
    }

    fun fetchNextPage() {
        _loading.value?.let { isLoading ->
            if (!isLoading) {
                _loading.value = true
                currentPage++
                viewModelScope.launch(dispatcher) {
                    val repoResult = repository.getMovies(currentPage)

                    // Only used to test the pagination feature
                    //Thread.sleep(3000)

                    when (repoResult) {
                        is RepositoryResult.Error -> _errorMsg.postValue(repoResult.message)
                        is RepositoryResult.Success -> {
                            val result = repoResult.data?.let { response ->
                                val movies = _moviesList.value ?: mutableListOf()
                                movies.addAll(response.results)
                                movies.sortedByDescending { it.popularity }
                                movies
                            }
                            _moviesList.postValue(result)
                        }
                    }.exhaustive
                    _loading.postValue(false)
                }
            }
        }
    }

    fun selectedMovie(movie: Movie) {
        _movieDetails.value = movie
    }
}