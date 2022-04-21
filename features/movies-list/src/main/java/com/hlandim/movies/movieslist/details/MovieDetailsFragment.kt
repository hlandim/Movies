package com.hlandim.movies.movieslist.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.hlandim.movies.movieslist.MoviesViewModel

class MovieDetailsFragment : Fragment() {

    private val moviesViewModel by activityViewModels<MoviesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            moviesViewModel.movieDetails.observe(viewLifecycleOwner) {
                setContent {
                    MovieDetailsScreen(it)
                }
            }
        }
    }
}