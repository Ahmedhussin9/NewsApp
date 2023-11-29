package com.example.data.datasource.news

import com.example.data.contracts.NewsDataSource
import com.example.data.repository.news.NewsRepositoryImpl
import com.example.domain.repository.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class di {
    @Binds
    abstract fun provideNewsDataSource(
         newsDataSourceImpl: NewsDataSourceImpl
    ):NewsDataSource

}