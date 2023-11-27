package com.example.data.repository.sources

import com.example.data.contracts.SourcesDataSource
import com.example.domain.model.Source
import com.example.domain.repository.SourcesRepository
import javax.inject.Inject

class SourcesRepositoryImpl @Inject constructor(
    val dataSource: SourcesDataSource
):SourcesRepository {
    override suspend fun getSourcesRepository(): List<Source?>? {
       return dataSource.getSources()
    }
}