package com.example.bookmyshowclone.data.local.entity

import com.google.gson.annotations.SerializedName

data class Movie(

        val id : Int,

        @SerializedName("poster_path")
        val posterPath: String,

        @SerializedName("release_date")
        val releaseDate: String,

        val title: String,

        @SerializedName("vote_average")
        val voteAverage: Double,

        @SerializedName("vote_count")
        val voteCount: Int
)

/*

object Movies {

    private val posterPaths = arrayListOf(
            "/6CoRTJTmijhBLJTUNoVSUNxZMEI.jpg",
            "/qzA87Wf4jo1h8JMk9GilyIYvwsA.jpg",
            "/aKx1ARwG55zZ0GpRvU2WrGrCG9o.jpg",
            "/ugZW8ocsrfgI95pnQ7wrmKDxIe.jpg",
            "/9Rj8l6gElLpRL7Kj17iZhrT5Zuw.jpg",
            "/uOw5JD8IlD546feZ6oxbIjvN66P.jpg",
            "/sMO1v5TUf8GOJHbJieDXsgWT2Ud.jpg",
            "/sy6DvAu72kjoseZEjocnm2ZZ09i.jpg",
            "/i4kPwXPlM1iy8Jf3S1uuLuwqQAV.jpg",
            "/4BgSWFMW2MJ0dT5metLzsRWO7IJ.jpg"
    )

    private val releaseDates = arrayListOf(
            "2020-09-29", "2020-08-06", "2020-09-10", "2020-08-25", "2020-08-28",
            "2020-08-20", "2020-08-28", "2020-07-15", "2020-08-25", "2020-10-09"
    )

    private val titles = arrayListOf(
            "Money Plane", "Ava", "Mulan", "Hard Kill", "Santana",
            "Rogue", "Unknown Origins", "Peninsula", "One Night in Bangkok", "Cats & Dogs 3: Paws Unite",
    )

    private val voteAverages = arrayListOf(
            5.5, 6.0, 7.4, 5.0, 5.8, 5.9, 6.2, 7.1, 7.3, 0.0
    )

    private val voteCounts = arrayListOf(
            27, 348, 2041, 96, 115, 264, 186, 514, 92, 0
    )

    /*var list: ArrayList<Movie>? = null
        get() {

            if (field != null)      // backing 'field' refers to 'list' property object
                return field

            field = ArrayList()
            for (i in titles.indices) {

                val posterPath = posterPaths[i]
                val releaseDate = releaseDates[i]
                val title = titles[i]
                val voteAverage = voteAverages[i]
                val voteCount = voteCounts[i]
                val movie = Movie(posterPath, releaseDate, title, voteAverage, voteCount)
                field!!.add(movie)
            }

            return field
        }*/
}

*/