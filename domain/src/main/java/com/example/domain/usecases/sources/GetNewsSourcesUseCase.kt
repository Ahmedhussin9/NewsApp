package com.example.domain.usecases.sources

import com.example.domain.model.sourcesResponse.Source
import com.example.domain.repository.SourcesRepository
import javax.inject.Inject

class GetNewsSourcesUseCase @Inject constructor(
    val repository: SourcesRepository,
) {
    suspend fun invoke(categoryId:String):List<Source?>?{
      return  repository.getSourcesRepository(categoryId)
    }
}