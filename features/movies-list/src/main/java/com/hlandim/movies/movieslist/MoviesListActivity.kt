package com.hlandim.movies.movieslist

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.hlandim.movies.movieslist.details.MovieDetailsFragment
import com.hlandim.movies.movieslist.list.MoviesListFragment
import dagger.hilt.android.AndroidEntryPoint
import com.hlandim.movies.common.ui.R as UiResource

@AndroidEntryPoint
class MoviesListActivity : AppCompatActivity() {

    private val moviesViewModel: MoviesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

        moviesViewModel.movieDetails.observe(this) {
            showDetailsFragment()
        }

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.content, MoviesListFragment())
            .commitNow()
    }

    private fun showDetailsFragment() {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                UiResource.anim.slide_in,
                UiResource.anim.fade_out,
                UiResource.anim.fade_in,
                UiResource.anim.slide_out
            )
            .add(
                R.id.content,
                MovieDetailsFragment(),
                MovieDetailsFragment::class.simpleName
            )
            .addToBackStack(null)
            .commit()
    }
}