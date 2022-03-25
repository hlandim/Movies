package com.hlandim.movies.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class Movie(

    val id: Int,

    @SerializedName("original_title")
    val title: String,

    @SerializedName("poster_path")
    val thumbnailPath: String?,

    val popularity: Double,

    @SerializedName("release_date")
    val releaseDate: Date


) {
    fun getReleaseDateYear(): Int {
        val calendar: Calendar = GregorianCalendar()
        calendar.time = releaseDate
        return calendar[Calendar.YEAR]
    }
}