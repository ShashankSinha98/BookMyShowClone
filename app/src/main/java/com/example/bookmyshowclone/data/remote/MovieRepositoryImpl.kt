package com.example.bookmyshowclone.data.remote

import com.example.bookmyshowclone.data.local.dao.MovieDao
import com.example.bookmyshowclone.data.local.entity.MovieResponse
import com.example.bookmyshowclone.data.remote.retrofit.MovieService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepositoryImpl(
        private val movieDao: MovieDao,
        private val request : MovieService
) : MovieRepository{


    // From Network
    override fun fetchMovies(API_KEY: String, onSuccess : (MovieResponse)->Unit, onError : (String)->Unit) {

        val call : Call<MovieResponse> = request.getMovies(API_KEY) // Getting movies from API


        // enqueue fn create http request in background
        // Making getMovies request to server

        call.enqueue(object : Callback<MovieResponse> {

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {


                if(response.isSuccessful && response.body() != null){
                    // success
                    Thread{
                        movieDao.insertMovie(response.body()!!)
                        onSuccess(response.body()!!)
                    }.start()

                } else {
                    // error
                    onError(response.message())
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                // error
                onError(t.localizedMessage ?:   "Oops! Something went wrong!!")
            }

        })
    }

    // From Local Database
    override fun getMoviesLocal(onSuccess: (MovieResponse?) -> Unit) {
        Thread{
            onSuccess(movieDao.getMovies())
        }.start()
    }

}