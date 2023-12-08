package com.example.newsapp.ui.activites.news

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.newsResponse.News
import com.example.domain.model.sourcesResponse.Source
import com.example.domain.usecases.news.GetNewsUseCase
import com.example.domain.usecases.sources.GetNewsSourcesUseCase
import com.example.newsapp.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject
@HiltViewModel
class NewsViewModel @Inject constructor(
    var getNewsSourcesUseCase: GetNewsSourcesUseCase,
    var getNewsUseCase: GetNewsUseCase
): ViewModel(),NewsContract.ViewModel {
    private var _events=
        SingleLiveEvent<NewsContract.Event>()
    override val events: SingleLiveEvent<NewsContract.Event> = _events
    private val _states = MutableLiveData<NewsContract.State>()
    override val states: MutableLiveData<NewsContract.State> = _states

    val sourcesLiveData = MutableLiveData<List<Source?>?>()
    override fun invoke(action: NewsContract.Action) {
        when(action){
            is NewsContract.Action.GetNewsSources->getNewsSources(action.categoryId)
            is NewsContract.Action.GetArticles->getArticles(action.sourceId)
            is NewsContract.Action.OnArticleClick->navigateToArticleDetails(action.article)
        }
    }

    private fun navigateToArticleDetails(article: News) {
        _events.postValue(NewsContract.Event.NavigateToArticleDetails(article))
    }

    private fun getArticles(sourceId: String?) {
        _states.postValue(NewsContract.State.Loading())
        viewModelScope.launch {
            try {
                val data = sourceId?.let { getNewsUseCase.invoke(it) }
                _states.postValue(NewsContract.State.ArticlesSuccess(data = data))
            }catch (e:Exception){
                _states.postValue(NewsContract.State.Error("Please Try Again"))
            }
        }

    }
    fun getNewsSources(categoryId: String?) {
        _states.postValue(NewsContract.State.Loading())
        viewModelScope.launch {
            try {
                val data = categoryId?.let { getNewsSourcesUseCase.invoke(it) }
                _states.postValue(NewsContract.State.SourcesSuccess(data))
            }catch (e:Exception){
                _states.postValue(NewsContract.State.Error("Please Try Again"))
            }
        }
    }
}