package com.learn.personal.moviet.data

import androidx.lifecycle.LiveData
import com.learn.personal.moviet.data.models.Movie
import com.learn.personal.moviet.data.models.TvShow

interface CatalogDataSource {
    fun getMovies(page: Int): LiveData<List<Movie>>

    fun getMovieDetail(movieId: Int): LiveData<Movie>

    fun getTvShows(page: Int): LiveData<List<TvShow>>

    fun getTvShowDetail(tvShowId: Int): LiveData<TvShow>
}