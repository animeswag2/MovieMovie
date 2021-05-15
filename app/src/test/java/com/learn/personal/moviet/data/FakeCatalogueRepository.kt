package com.learn.personal.moviet.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.learn.personal.moviet.data.models.Movie
import com.learn.personal.moviet.data.models.TvShow
import com.learn.personal.moviet.data.remote.RemoteDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FakeCatalogueRepository (
        private val remoteDataSource: RemoteDataSource
): CatalogDataSource {

    override fun getMovies(page: Int): LiveData<List<Movie>> {
        val listMovieResult = MutableLiveData<List<Movie>>()
        CoroutineScope(Dispatchers.IO).launch {
            remoteDataSource.getMovies(page, object : RemoteDataSource.LoadMoviesCallback{
                override fun onAllMoviesReceived(movieResponse: List<Movie>) {
                    val movieList = ArrayList<Movie>()
                    for (response in movieResponse){
                        val movie = Movie(
                                id = response.id,
                                title = response.title,
                                overview = response.overview,
                                poster = response.poster,
                                vote = response.vote,
                                release = response.release
                        )
                        movieList.add(movie)
                    }
                    listMovieResult.postValue(movieList)
                }
            })
        }

        return listMovieResult
    }

    override fun getMovieDetail(movieId: Int): LiveData<Movie> {
        val movieResult = MutableLiveData<Movie>()
        CoroutineScope(Dispatchers.IO).launch {
            remoteDataSource.getMovieDetail(movieId, object : RemoteDataSource.LoadMovieDetailCallback{
                override fun onMovieDetailReceived(movieResponse: Movie) {
                    val movie = Movie(
                            id = movieResponse.id,
                            title = movieResponse.title,
                            overview = movieResponse.overview,
                            poster = movieResponse.poster,
                            vote = movieResponse.vote,
                            release = movieResponse.release
                    )

                    movieResult.postValue(movie)
                }
            })
        }

        return movieResult
    }

    override fun getTvShows(page: Int): LiveData<List<TvShow>> {
        val listTvShowResult = MutableLiveData<List<TvShow>>()
        CoroutineScope(Dispatchers.IO).launch {
            remoteDataSource.getTvShows(page, object : RemoteDataSource.LoadTvShowsCallback{
                override fun onAllTvShowsReceived(tvShowResponse: List<TvShow>) {
                    val tvShowList = ArrayList<TvShow>()
                    for (response in tvShowResponse){
                        val tvShow = TvShow(
                                id = response.id,
                                title = response.title,
                                overview = response.overview,
                                poster = response.poster,
                                vote = response.vote,
                                release = response.release
                        )
                        tvShowList.add(tvShow)
                    }

                    listTvShowResult.postValue(tvShowList)
                }
            })
        }

        return listTvShowResult
    }

    override fun getTvShowDetail(tvShowId: Int): LiveData<TvShow> {
        val tvShowResult = MutableLiveData<TvShow>()
        CoroutineScope(Dispatchers.IO).launch {
            remoteDataSource.getTvShowDetail(tvShowId, object : RemoteDataSource.LoadTvShowDetailCallback{
                override fun onTvShowDetailReceived(tvShowResponse: TvShow) {
                    val tvShow = TvShow(
                            id = tvShowResponse.id,
                            title = tvShowResponse.title,
                            overview = tvShowResponse.overview,
                            poster = tvShowResponse.poster,
                            vote = tvShowResponse.vote,
                            release = tvShowResponse.release
                    )

                    tvShowResult.postValue(tvShow)
                }
            })
        }

        return tvShowResult
    }
}