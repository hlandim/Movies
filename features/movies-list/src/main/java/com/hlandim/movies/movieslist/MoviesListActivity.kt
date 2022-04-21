package com.hlandim.movies.movieslist

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.hlandim.movies.movieslist.details.MovieDetailsFragment
import com.hlandim.movies.movieslist.list.MoviesListFragment
import dagger.hilt.android.AndroidEntryPoint

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
                com.hlandim.movies.common.ui.R.anim.slide_in,
                com.hlandim.movies.common.ui.R.anim.fade_out,
                com.hlandim.movies.common.ui.R.anim.fade_in,
                com.hlandim.movies.common.ui.R.anim.slide_out
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