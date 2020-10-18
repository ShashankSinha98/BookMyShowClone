package com.example.bookmyshowclone.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bookmyshowclone.R
import com.example.bookmyshowclone.data.local.entity.Movie
import kotlinx.android.synthetic.main.movie_item_layout.view.*

class MoviesAdapter(private val movies : List<Movie>) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item_layout,parent,false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount() = movies.count()



    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        companion object {
            private const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500"
        }
        fun bind(movie: Movie){
            itemView.movieTitle.text = movie.title
            itemView.releaseDate.text = movie.releaseDate
            itemView.averageVoting.text = movie.voteAverage.toString()
            itemView.totalVotes.text = movie.voteCount.toString()

            // pass view context
            Glide.with(itemView.context).load(IMAGE_BASE_URL + movie.posterPath).into(itemView.moviePoster)
        }
    }


}