package com.learn.personal.moviet.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.learn.personal.moviet.data.CatalogueRepository
import com.learn.personal.moviet.data.models.Movie
import com.learn.personal.moviet.data.models.TvShow
import com.learn.personal.moviet.utils.DataDummy
import junit.framework.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest {

    private lateinit var homeViewModel: HomeViewModel

    private val dummyMovie = DataDummy.generateMoviesList()[0]
    private val movieId = dummyMovie.id
    private val dummyTvShow = DataDummy.generateTvShowsList()[1]
    private val tvShowId = dummyTvShow.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Before
    fun setUp() {
        homeViewModel = HomeViewModel(catalogueRepository)
    }

    @Test
    fun testGetListMovies() {
        val movies = MutableLiveData<List<Movie>>()
        val mockMovieList: List<Movie> = Mockito.mock(List::class.java) as List<Movie>
        movies.value = mockMovieList

        Mockito.`when`(catalogueRepository.getMovies(1)).thenReturn(movies)
        val observerMovie = Mockito.mock(Observer::class.java) as Observer<List<Movie>>

        homeViewModel.getListMovies().observeForever(observerMovie)

        Mockito.verify(observerMovie).onChanged(mockMovieList)
    }

    @Test
    fun testGetListTvShows() {
        val tvShows = MutableLiveData<List<TvShow>>()
        val mockTvShowList: List<TvShow> = Mockito.mock(List::class.java) as List<TvShow>
        tvShows.value = mockTvShowList

        Mockito.`when`(catalogueRepository.getTvShows(1)).thenReturn(tvShows)
        val observerTvShow = Mockito.mock(Observer::class.java) as Observer<List<TvShow>>

        homeViewModel.getListTvShows().observeForever(observerTvShow)

        Mockito.verify(observerTvShow).onChanged(mockTvShowList)
    }

    @Test
    fun testGetMovieDetail() {
        val movie: MutableLiveData<Movie> = MutableLiveData()
        movie.postValue(dummyMovie)

        Mockito.`when`(catalogueRepository.getMovieDetail(movieId)).thenReturn(movie)
        val observerMovieDetail = Mockito.mock(Observer::class.java) as Observer<Movie>

        val movieDetail = homeViewModel.getMovieById(movieId).value as Movie

        assertNotNull(movieDetail)
        assertEquals(dummyMovie.id, movieDetail.id)
        assertEquals(dummyMovie.title, movieDetail.title)
        assertEquals(dummyMovie.vote, movieDetail.vote)
        assertEquals(dummyMovie.overview, movieDetail.overview)
        assertEquals(dummyMovie.poster, movieDetail.poster)
        assertEquals(dummyMovie.release, movieDetail.release)

        homeViewModel.getMovieById(movieId).observeForever(observerMovieDetail)
        Mockito.verify(observerMovieDetail).onChanged(dummyMovie)
    }

    @Test
    fun testGetTvShowDetail() {
        val tvShow: MutableLiveData<TvShow> = MutableLiveData()
        tvShow.postValue(dummyTvShow)

        Mockito.`when`(catalogueRepository.getTvShowDetail(tvShowId)).thenReturn(tvShow)
        val observerTvShowDetail = Mockito.mock(Observer::class.java) as Observer<TvShow>

        val tvShowDetail = homeViewModel.getTvShowById(tvShowId).value as TvShow

        assertNotNull(tvShowDetail)
        assertEquals(dummyTvShow.id, tvShowDetail.id)
        assertEquals(dummyTvShow.title, tvShowDetail.title)
        assertEquals(dummyTvShow.vote, tvShowDetail.vote)
        assertEquals(dummyTvShow.overview, tvShowDetail.overview)
        assertEquals(dummyTvShow.poster, tvShowDetail.poster)
        assertEquals(dummyTvShow.release, tvShowDetail.release)

        homeViewModel.getTvShowById(tvShowId).observeForever(observerTvShowDetail)
        Mockito.verify(observerTvShowDetail).onChanged(dummyTvShow)
    }
}