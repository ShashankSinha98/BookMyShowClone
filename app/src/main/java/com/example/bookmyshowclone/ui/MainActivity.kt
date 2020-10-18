package com.example.bookmyshowclone.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import com.example.bookmyshowclone.ui.adapter.MoviesAdapter
import com.example.bookmyshowclone.util.NetworkHelper
import com.example.bookmyshowclone.R
import com.example.bookmyshowclone.data.local.MovieDatabase
import com.example.bookmyshowclone.data.remote.MovieRepositoryImpl
import com.example.bookmyshowclone.data.local.entity.Movie
import com.example.bookmyshowclone.data.remote.retrofit.RetrofitBuilder
import com.example.bookmyshowclone.ui.util.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var viewModelFactory : MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpViewModel()
        observeViewModel()

    }

    private fun setUpViewModel() {

        showProgress()

        viewModel = ViewModelProvider(
                this,MainViewModelFactory(
                NetworkHelper(this),
                MovieRepositoryImpl(MovieDatabase.getInstance(this).movieDao,RetrofitBuilder.buildService())
        )
        ).get(MainViewModel::class.java)
        viewModel.onCreate()
    }

    private fun observeViewModel(){

        viewModel.movieResponse.observe(this, Observer {
            showMovies(it.results)
            hideProgress()
        })

        viewModel.errorResponse.observe(this, Observer {
            showErrorMessage(it)
            hideProgress()
        })
    }




    private fun showMovies(movies: List<Movie>) {
        recyclerView.visibility = View.VISIBLE
        progressBar.visibility = View.GONE
        recyclerView.setHasFixedSize(true) // performance improvement - not calculate item size every time
        recyclerView.itemAnimator = DefaultItemAnimator() // Animations
        recyclerView.adapter = MoviesAdapter(movies)
    }

    private fun showErrorMessage(errorMessage: String?) {
        errorView.visibility = View.VISIBLE
        errorView.text = errorMessage
    }

    private fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    private fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }
}