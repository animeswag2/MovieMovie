package com.learn.personal.moviet.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.learn.personal.moviet.data.CatalogueRepository
import com.learn.personal.moviet.data.models.Movie
import com.learn.personal.moviet.data.models.TvShow
import com.learn.personal.moviet.di.Injector

class HomeViewModel(
    private val catalogueRepository: CatalogueRepository
) : ViewModel() {

    companion object {
        @Volatile
        private var instance: HomeViewModel? = null

        fun getInstance(): HomeViewModel =
            instance ?: synchronized(this) {
                instance ?: HomeViewModel(Injector.provideRepository())
            }
    }

    var page: Int = 1

    fun getListMovies(): LiveData<List<Movie>> = catalogueRepository.getMovies(page)

    fun getListTvShows(): LiveData<List<TvShow>> = catalogueRepository.getTvShows(page)

    fun getMovieById(id: Int): LiveData<Movie> {
        return catalogueRepository.getMovieDetail(id)
    }

    fun getTvShowById(id: Int): LiveData<TvShow> {
        return catalogueRepository.getTvShowDetail(id)
    }
}