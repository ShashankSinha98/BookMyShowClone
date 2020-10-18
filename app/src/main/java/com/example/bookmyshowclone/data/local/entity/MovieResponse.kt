package com.example.bookmyshowclone.data.local.entity

import androidx.room.*
import com.example.bookmyshowclone.data.local.typeConverter.MovieTypeConverter

/*
*   Our http response consist of json obj, inside it we have json array of json movie obj
*   So, this class  basically correspond to outer class and inner results variable(name must be same as in resp key)
*   results represents the json array inside it. (This array consists movies data in form of Json obj)
*/

@Entity(tableName = "tbl_movie_data")
data class MovieResponse(

    @PrimaryKey
    val page: Int = 1,

    @ColumnInfo(name="movie_response")
    @TypeConverters(MovieTypeConverter::class) // we can only store primitive data, so need a converter to convert it into string first
    val results : List<Movie>
)