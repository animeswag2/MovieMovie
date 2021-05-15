package com.learn.personal.moviet.utils

import com.learn.personal.moviet.data.models.Movie
import com.learn.personal.moviet.data.models.TvShow

object DataDummy {
    fun generateTvShowsList(): List<TvShow> {
        val tvShows = ArrayList<TvShow>()
        tvShows.add(
            TvShow(
                id = 88396,
                title = "The Falcon and the Winter Soldier",
                overview = "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                poster = "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                vote = 7.9F,
                release = "2021-03-19"
            )
        )

        tvShows.add(
            TvShow(
                id = 71712,
                title = "The Good Doctor",
                overview = "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives.",
                poster = "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                vote = 8.6F,
                release = "2017-09-25"
            )
        )

        return tvShows
    }

    fun generateMoviesList(): List<Movie> {
        val movies = ArrayList<Movie>()
        movies.add(
            Movie(
                id = 88396,
                title = "The Falcon and the Winter Soldier",
                overview = "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                poster = "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                vote = 7.9F,
                release = "2021-03-19"
            )
        )

        movies.add(
            Movie(
                id = 71712,
                title = "The Good Doctor",
                overview = "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives.",
                poster = "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                vote = 8.6F,
                release = "2017-09-25"
            )
        )

        return movies
    }
}