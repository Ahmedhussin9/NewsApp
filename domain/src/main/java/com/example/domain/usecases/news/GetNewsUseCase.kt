package com.example.domain.usecases.news

import com.example.domain.model.newsResponse.News
import com.example.domain.repository.NewsRepository
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
       val newsRepository: NewsRepository
) {
    suspend fun invoke(sourceId:String):List<News?>?{
        val data= newsRepository.getNewsRepository(sourceId)
        return data
    }
}