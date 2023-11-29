package com.example.domain.repository

import com.example.domain.model.sourcesResponse.Source

interface SourcesRepository {
    suspend fun getSourcesRepository(categoryId:String):List<Source?>?
}