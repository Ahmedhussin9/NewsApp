package com.example.data.datasource.sources

import com.example.data.contracts.SourcesDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class di {
    @Binds
    abstract fun provideSourcesDataSource(
        sourcesDataSourceImpl: SourcesDataSourceImpl
    ):SourcesDataSource

}