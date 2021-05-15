package com.learn.personal.moviet.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Film (
    var id: String,
    var title: String,
    var description: String,
    var info: String,
    var poster: Int
) : Parcelable