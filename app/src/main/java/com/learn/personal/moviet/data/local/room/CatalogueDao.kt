package com.learn.personal.moviet.data.local.room

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Query
import com.learn.personal.moviet.data.local.entity.MovieEntity

@Dao
interface CatalogueDao {

    @Query("SELECT * FROM movieentities")
    fun getMovies(): DataSource.Factory<Int, MovieEntity>

    @Query("")

}