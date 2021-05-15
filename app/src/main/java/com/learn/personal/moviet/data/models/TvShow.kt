package com.learn.personal.moviet.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShow(
    @SerializedName("id")
    val id: Int = 0,

    @SerializedName("name")
    val title: String? = null,

    @SerializedName("overview")
    val overview: String? = null,

    @SerializedName("poster_path")
    val poster: String? = null,

    @SerializedName("vote_average")
    val vote: Float = 0.0F,

    @SerializedName("first_air_date")
    val release: String? = null,
) : Parcelable