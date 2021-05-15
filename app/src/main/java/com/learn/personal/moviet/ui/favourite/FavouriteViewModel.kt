package com.learn.personal.moviet.ui.favourite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.learn.personal.moviet.data.CatalogueRepository

class FavouriteViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {
    fun getBookmarks(): LiveData<PagedList<MovieEntity>> = academyRepository.getBookmarkedCourses()

    fun setBookmark(courseEntity: CourseEntity) {
        val newState = !courseEntity.bookmarked
        academyRepository.setCourseBookmark(courseEntity, newState  )
    }
}

