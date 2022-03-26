package com.hlandim.movies.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.hlandim.movies.model.Movie
import java.util.Date
import kotlin.random.Random

object Utils {
    fun hasInternetConnection(context: Context?): Boolean {
        if (context == null)
            return false
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE)
                as ConnectivityManager

        val activeNetwork = connectivityManager.activeNetwork ?: return false
        val networkCapabilities =
            connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false

        return when {
            networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }

    fun createMovieMock(title: String) =
        Movie(Random.nextInt(), title, "", "", Random.nextDouble(), Date())
}