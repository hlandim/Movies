package com.hlandim.movies.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.hlandim.movies.viewmodel.MoviesViewModel

class MovieDetailsFragment : Fragment() {

    private val moviesViewModel by activityViewModels<MoviesViewModel>()

    companion object {
        private const val ARG_MOVIE_ID = "arg_movie_id"
        fun newInstance(movieId: Int): MovieDetailsFragment {
            return MovieDetailsFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_MOVIE_ID, movieId)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val movieId = arguments?.getInt(ARG_MOVIE_ID)
        return ComposeView(requireContext()).apply {
            setContent {
                MovieDetailsScreen(moviesViewModel, movieId)
            }
        }
    }
}