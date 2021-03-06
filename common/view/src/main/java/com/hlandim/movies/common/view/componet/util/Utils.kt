package com.hlandim.movies.common.view.componet.util

import com.hlandim.movies.common.data.Movie
import java.util.Date
import kotlin.random.Random

object Utils {
    // Used by compose components to generate data used by the Preview tool
    fun createMovieMock(title: String) =
        Movie(
            Random.nextInt(),
            title,
            "",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. ",
            "",
            Random.nextDouble(),
            Date()
        )
}