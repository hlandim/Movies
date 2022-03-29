package com.hlandim.movies.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.hlandim.movies.viewmodel.MoviesViewModel

class MovieDetailsFragment : Fragment() {

    private val moviesViewModel by activityViewModels<MoviesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            moviesViewModel.movieDetails.observe(viewLifecycleOwner, Observer {
                setContent {
                    MovieDetailsScreen(it)
                }
            })
        }
    }
}