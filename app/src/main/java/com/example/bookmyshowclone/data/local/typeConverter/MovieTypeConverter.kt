package com.example.bookmyshowclone.data.local.typeConverter

import androidx.room.TypeConverter
import com.example.bookmyshowclone.data.local.entity.Movie
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


// converts list of movies to sting and then back to list
object MovieTypeConverter {

    @TypeConverter
    @JvmStatic
    fun fromList(value: List<Movie>) = Gson().toJson(value)

    @TypeConverter
    @JvmStatic
    fun toList(value: String): List<Movie> {
        val listType : Type = object : TypeToken<List<Movie>>() {}.type
        return Gson().fromJson(value,listType)
    }

}