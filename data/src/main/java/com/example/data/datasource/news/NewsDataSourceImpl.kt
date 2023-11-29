package com.example.data.datasource.news

import com.example.data.api.WebServices
import com.example.data.contracts.NewsDataSource
import javax.inject.Inject

class NewsDataSourceImpl @Inject constructor(
    var webServices: WebServices
):NewsDataSource {
    override suspend fun getNews(categoryId: String): List<com.example.domain.model.newsResponse.News?>? {
        val response =webServices.getNews(sources = categoryId)
        return response.articles
    }
}