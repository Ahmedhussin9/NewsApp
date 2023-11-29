package com.example.data.contracts

import com.example.domain.model.newsResponse.News

interface NewsDataSource {
suspend    fun getNews(categoryId:String):List<News?>?
}