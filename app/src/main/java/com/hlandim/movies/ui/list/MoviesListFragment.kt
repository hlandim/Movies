package com.hlandim.movies.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.hlandim.movies.viewmodel.MoviesViewModel


@ExperimentalFoundationApi
class MoviesListFragment : Fragment() {

    private val moviesViewModel by activityViewModels<MoviesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                MoviesListScreen(moviesViewModel) {
                    val action = MoviesListFragmentDirections.actionMoviesListFragmentToMovieDetailsFragment(it.id)
                    findNavController().navigate(action)
                }
            }
        }
    }
}