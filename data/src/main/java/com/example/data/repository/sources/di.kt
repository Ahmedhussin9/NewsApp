package com.example.data.repository.sources

import com.example.domain.repository.SourcesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class di {
    @Binds
    abstract fun provideSourcesRepository(
        sourcesRepositoryImpl: SourcesRepositoryImpl
    ):SourcesRepository
}