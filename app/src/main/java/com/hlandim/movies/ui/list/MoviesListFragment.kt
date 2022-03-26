package com.hlandim.movies.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.hlandim.movies.R
import com.hlandim.movies.model.Movie
import com.hlandim.movies.ui.details.MovieDetailsFragment
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
                    showDetailsScreen(it)
                }
            }
        }
    }

    private fun showDetailsScreen(movie: Movie) {
        activity?.let {
            it.supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(
                    R.anim.slide_in,
                    R.anim.fade_out,
                    R.anim.fade_in,
                    R.anim.slide_out
                )
                .add(
                    R.id.content,
                    MovieDetailsFragment.newInstance(movie.id),
                    MovieDetailsFragment::class.simpleName
                )
                .addToBackStack(null)
                .commit()
        }
    }
}