package com.learn.personal.moviet.data.remote

import com.learn.personal.moviet.data.api.ApiClient
import com.learn.personal.moviet.data.api.TmdbApi
import com.learn.personal.moviet.data.models.Movie
import com.learn.personal.moviet.data.models.TvShow
import com.learn.personal.moviet.utils.EspressoIdlingResource
import retrofit2.await

class RemoteDataSource {
    private val tmdbApiClient = ApiClient.initClient().create(TmdbApi::class.java)

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource()
            }
    }

    suspend fun getMovies(
        page: Int,
        callback: LoadMoviesCallback
    ) {
        EspressoIdlingResource.increment()
        tmdbApiClient.getMovies(page).await().results.let { listMovie ->
            if (listMovie != null) {
                callback.onAllMoviesReceived(
                    listMovie
                )
            }
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getMovieDetail(
        movieId: Int,
        callback: LoadMovieDetailCallback
    ) {
        EspressoIdlingResource.increment()
        tmdbApiClient.getMovieDetail(movieId).await().let { movie ->
            callback.onMovieDetailReceived(
                movie
            )
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getTvShows(
        page: Int,
        callback: LoadTvShowsCallback
    ) {
        EspressoIdlingResource.increment()
        tmdbApiClient.getTvShows(page).await().results.let { listTvShow ->
            if (listTvShow != null) {
                callback.onAllTvShowsReceived(
                    listTvShow
                )
            }
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getTvShowDetail(
        tvShowId: Int,
        callback: LoadTvShowDetailCallback
    ) {
        EspressoIdlingResource.increment()
        tmdbApiClient.getTvShowDetail(tvShowId).await().let { tvShow ->
            callback.onTvShowDetailReceived(
                tvShow
            )
            EspressoIdlingResource.decrement()
        }
    }

    interface LoadMoviesCallback {
        fun onAllMoviesReceived(movieResponse: List<Movie>)
    }

    interface LoadMovieDetailCallback {
        fun onMovieDetailReceived(movieResponse: Movie)
    }

    interface LoadTvShowsCallback {
        fun onAllTvShowsReceived(tvShowResponse: List<TvShow>)
    }

    interface LoadTvShowDetailCallback {
        fun onTvShowDetailReceived(tvShowResponse: TvShow)
    }
}