package com.learn.personal.moviet.di

import com.learn.personal.moviet.data.CatalogueRepository
import com.learn.personal.moviet.data.remote.RemoteDataSource

class Injector {
    companion object {
        fun provideRepository(): CatalogueRepository {
            val remoteDataSource = RemoteDataSource.getInstance()
            return CatalogueRepository.getInstance(remoteDataSource)
        }
    }
}