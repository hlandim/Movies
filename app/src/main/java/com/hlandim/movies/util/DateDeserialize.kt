package com.hlandim.movies.util

import android.util.Log
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DateDeserialize : JsonDeserializer<Date> {
    override fun deserialize(
        dateJson: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Date? {
        return dateJson?.let {
            val date: String = it.asString
            val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            return try {
                formatter.parse(date)
            } catch (e: ParseException) {
                Log.e("DateDeserialize", "Error parsing date: $date")
                return null
            }

        }
    }
}