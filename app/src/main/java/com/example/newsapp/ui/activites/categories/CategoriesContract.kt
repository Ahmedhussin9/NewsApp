package com.example.newsapp.ui.activites.categories

import com.example.newsapp.SingleLiveEvent

class CategoriesContract {
    interface ViewModel{
        val events : SingleLiveEvent<Events>
        fun invokeAction(action: Action)
    }
    sealed class Action{
        class LoadCategories():Action()
        class OnCategoryClick(var item:CategoriesDataClass):Action()
    }
    sealed class Events{
        class NavigateToNews(var item:CategoriesDataClass):Events()
    }
    sealed class States{

    }
}