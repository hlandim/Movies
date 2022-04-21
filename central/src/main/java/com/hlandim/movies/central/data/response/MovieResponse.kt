package com.hlandim.movies.central.data.response

import com.google.gson.annotations.SerializedName
import java.util.Calendar
import java.util.Date
import java.util.GregorianCalendar

data class MovieResponse(

    val id: Int,

    @SerializedName("original_title")
    val title: String,

    @SerializedName("backdrop_path")
    val backDropPath: String?,

    val overview: String?,

    @SerializedName("poster_path")
    val posterPath: String?,

    val popularity: Double,

    @SerializedName("release_date")
    val releaseDate: Date?


) {
    fun getReleaseDateYear(): Int? {
        return if (releaseDate != null) {
            val calendar: Calendar = GregorianCalendar()
            calendar.time = releaseDate
            calendar[Calendar.YEAR]
        } else {
            null
        }
    }
}