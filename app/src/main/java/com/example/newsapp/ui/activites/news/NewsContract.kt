package com.example.newsapp.ui.activites.news

import androidx.lifecycle.MutableLiveData
import com.example.domain.model.newsResponse.News
import com.example.domain.model.sourcesResponse.Source
import com.example.newsapp.SingleLiveEvent

class NewsContract {
    interface ViewModel{
        val events: SingleLiveEvent<Event>
        val states:MutableLiveData<State>
         fun invoke(action: Action)
    }
    sealed class Action{
        class GetNewsSources(var categoryId:String?):NewsContract.Action()
        class GetArticles(var sourceId:String?):NewsContract.Action()
        class OnArticleClick(var article:News):Action()
    }
    sealed class Event{
        class NavigateToArticleDetails(var article: News):Event()
    }
    sealed class State{
        class SourcesSuccess(var data:List<Source?>?):State()
        class ArticlesSuccess(var data:List<News?>?):State()
        class Loading():State()
        class Error(val errorMessage:String):State()
    }
}