package com.example.bookmyshowclone.data.remote

import com.example.bookmyshowclone.data.local.entity.MovieResponse

interface MovieRepository {

    // From Network
    fun fetchMovies(API_KEY: String, onSuccess : (MovieResponse)->Unit, onError : (String)->Unit)

    // From Local Database
    fun getMoviesLocal(onSuccess: (MovieResponse?)->Unit)
}