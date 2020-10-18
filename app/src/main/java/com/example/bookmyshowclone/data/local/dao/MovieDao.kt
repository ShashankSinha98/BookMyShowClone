package com.example.bookmyshowclone.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.bookmyshowclone.data.local.entity.MovieResponse

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movieResponse: MovieResponse)

    @Query("SELECT * FROM tbl_movie_data")
    fun getMovies() : MovieResponse
}