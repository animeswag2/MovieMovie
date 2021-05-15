package com.learn.personal.moviet.data.api

import com.learn.personal.moviet.data.models.Movie
import com.learn.personal.moviet.data.models.TvShow
import com.learn.personal.moviet.data.remote.responses.MovieResponse
import com.learn.personal.moviet.data.remote.responses.TvShowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbApi {
    companion object {
        const val API_KEY = ApiConfig.TMDB_API_KEY
    }

    @GET("movie/popular?api_key=$API_KEY")
    fun getMovies(
        @Query("page") page: Int
    ): Call<MovieResponse>

    @GET("movie/{id}?api_key=$API_KEY")
    fun getMovieDetail(
        @Path("id") id: Int
    ): Call<Movie>

    @GET("tv/popular?api_key=$API_KEY")
    fun getTvShows(
        @Query("page") page: Int
    ): Call<TvShowResponse>

    @GET("tv/{id}?api_key=$API_KEY")
    fun getTvShowDetail(
        @Path("id") id: Int
    ): Call<TvShow>
}