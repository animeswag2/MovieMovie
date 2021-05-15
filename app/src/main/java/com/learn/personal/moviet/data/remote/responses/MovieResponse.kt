package com.learn.personal.moviet.data.remote.responses

import com.google.gson.annotations.SerializedName
import com.learn.personal.moviet.data.models.Movie

class MovieResponse {
    @SerializedName("results")
    val results: List<Movie>? = null
}