package com.example.bookmyshowclone.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.bookmyshowclone.data.local.dao.MovieDao
import com.example.bookmyshowclone.data.local.entity.MovieResponse
import com.example.bookmyshowclone.data.local.typeConverter.MovieTypeConverter

@Database(entities = [MovieResponse::class],version = 1)
@TypeConverters(MovieTypeConverter::class)
abstract class MovieDatabase: RoomDatabase(){

    abstract val movieDao : MovieDao

    companion object{
        private const val DATABASE_NAME = "movie-app"

        @Volatile
        private var INSTANCE : MovieDatabase?= null

        fun getInstance(context : Context) : MovieDatabase{
            synchronized(this){
                var instance : MovieDatabase? = INSTANCE

                if(instance == null){
                    instance = Room.databaseBuilder(
                            context.applicationContext,MovieDatabase::class.java,
                            DATABASE_NAME
                    ).build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}