package com.example.bookmyshowclone.data.remote.retrofit

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private const val BASE_URL = "https://api.themoviedb.org/3/"

    private val client : OkHttpClient = OkHttpClient.Builder().build()

    private val gson : Gson = GsonBuilder().create()

    private val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()

    fun buildService() : MovieService {
        return retrofit.create(MovieService::class.java)
    }
}