package com.example.domain.usecases.sources

import com.example.domain.repository.SourcesRepository
import javax.inject.Inject

class GetNewsSourcesUseCase @Inject constructor(
    val repository: SourcesRepository
) {
    suspend fun invoke(){
        repository.getSourcesRepository()
    }
}