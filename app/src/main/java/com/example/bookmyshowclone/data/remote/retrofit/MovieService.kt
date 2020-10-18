package com.example.bookmyshowclone.data.remote.retrofit

import com.example.bookmyshowclone.data.local.entity.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


// Interface for API calls, Retrofit will automatically provide implementation

interface MovieService {

    /*
    *   GET - for get request, "discover/movie" - part of final url
    *   https://api.themoviedb.org/3/discover/movie?api_key=7bc0651fe0ea5973822df3bd27e779d9
    *   This method will return Http response which will map to MovieResponse
    *   Notice, after discover/movie, we need to pass api key as query, so this fn will accept a query parameter, key as string
    * */
    @GET("discover/movie")
    fun getMovies(@Query("api_key") key: String): Call<MovieResponse>
}