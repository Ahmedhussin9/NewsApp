package com.example.domain.repository

import com.example.domain.model.newsResponse.News

interface NewsRepository {
    suspend fun getNewsRepository(sourceId:String):List<News?>?
}