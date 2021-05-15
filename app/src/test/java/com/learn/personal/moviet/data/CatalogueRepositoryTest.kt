package com.learn.personal.moviet.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.learn.personal.moviet.LiveDataTestUtil
import com.learn.personal.moviet.data.remote.RemoteDataSource
import com.learn.personal.moviet.utils.DataDummy
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class CatalogueRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val dataSource = Mockito.mock(RemoteDataSource::class.java)
    private val catalogRepository = FakeCatalogueRepository(dataSource)

    private val movies = DataDummy.generateMoviesList()
    private val movieId = movies[0].id

    private val tvShows = DataDummy.generateTvShowsList()
    private val tvShowId = tvShows[0].id

    private val movieResponse = DataDummy.generateMoviesList()[0]
    private val tvShowResponse = DataDummy.generateTvShowsList()[0]

    private val page = 1

    @Test
    fun getMovies() {
        runBlocking {
            doAnswer {invocation ->
                (invocation.arguments[1] as RemoteDataSource.LoadMoviesCallback).onAllMoviesReceived(movies)
                null
            }.`when`(dataSource).getMovies(eq(page), any())
        }

        val data = LiveDataTestUtil.getValue(catalogRepository.getMovies(page))

        runBlocking {
            verify(dataSource).getMovies(eq(page), any())
        }

        assertNotNull(data)
        assertEquals(movies.size.toLong(), data.size.toLong())
    }

    @Test
    fun getTvShows() {
        runBlocking {
            doAnswer {invocation ->
                (invocation.arguments[1] as RemoteDataSource.LoadTvShowsCallback).onAllTvShowsReceived(tvShows)
                null
            }.`when`(dataSource).getTvShows(eq(page), any())
        }

        val data = LiveDataTestUtil.getValue(catalogRepository.getTvShows(page))

        runBlocking {
            verify(dataSource).getTvShows(eq(page), any())
        }

        assertNotNull(data)
        assertEquals(tvShows.size.toLong(), data.size.toLong())
    }

    @Test
    fun getMovieDetail() {
        runBlocking {
            doAnswer {invocation ->
                (invocation.arguments[1] as RemoteDataSource.LoadMovieDetailCallback).onMovieDetailReceived(movieResponse)
                null
            }.`when`(dataSource).getMovieDetail(eq(movieId), any())
        }

        val data = LiveDataTestUtil.getValue(catalogRepository.getMovieDetail(movieId))

        runBlocking {
            verify(dataSource).getMovieDetail(eq(movieId), any())
        }

        assertNotNull(data)
        assertEquals(movieId, data.id)
    }

    @Test
    fun getTvShowDetail() {
        runBlocking {
            doAnswer {invocation ->
                (invocation.arguments[1] as RemoteDataSource.LoadTvShowDetailCallback).onTvShowDetailReceived(tvShowResponse)
                null
            }.`when`(dataSource).getTvShowDetail(eq(tvShowId), any())
        }

        val data = LiveDataTestUtil.getValue(catalogRepository.getTvShowDetail(tvShowId))

        runBlocking {
            verify(dataSource).getTvShowDetail(eq(tvShowId), any())
        }

        assertNotNull(data)
        assertEquals(tvShowId, data.id)
    }

}