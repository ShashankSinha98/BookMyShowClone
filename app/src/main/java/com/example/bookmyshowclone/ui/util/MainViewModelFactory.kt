package com.example.bookmyshowclone.ui.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bookmyshowclone.data.remote.MovieRepository
import com.example.bookmyshowclone.ui.MainViewModel
import com.example.bookmyshowclone.util.NetworkHelper

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(private val networkHelper: NetworkHelper,
                           private val movieRepository: MovieRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(networkHelper,movieRepository) as T
    }
}