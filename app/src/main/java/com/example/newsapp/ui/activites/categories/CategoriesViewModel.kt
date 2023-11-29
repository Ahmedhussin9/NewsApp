package com.example.newsapp.ui.activites.categories

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.SingleLiveEvent

class CategoriesViewModel(
) :ViewModel(),CategoriesContract.ViewModel {
    var catrgories = MutableLiveData<List<CategoriesDataClass>>()
    private val _events =
        SingleLiveEvent<CategoriesContract.Events>()
    override val events: SingleLiveEvent<CategoriesContract.Events> = _events
    override fun invokeAction(action: CategoriesContract.Action) {
        when (action){
            is CategoriesContract.Action.LoadCategories->LoadCategories()
            is CategoriesContract.Action.OnCategoryClick->OnCategoryClick(action.item)
        }
    }

    private fun LoadCategories(){
     val data= CategoriesDataClass.getCategories()
        catrgories.postValue(data)
    }
    private fun OnCategoryClick(item: CategoriesDataClass) {
        _events.postValue(CategoriesContract.Events.NavigateToNews(item))
    }
}