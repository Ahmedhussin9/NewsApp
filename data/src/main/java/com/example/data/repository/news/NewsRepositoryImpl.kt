package com.example.data.repository.news

import com.example.data.contracts.NewsDataSource
import com.example.domain.model.newsResponse.News
import com.example.domain.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    var newsDataSource: NewsDataSource
):NewsRepository {
    override suspend fun getNewsRepository(sourceId: String): List<News?>? {
        return newsDataSource.getNews(sourceId)
    }
}