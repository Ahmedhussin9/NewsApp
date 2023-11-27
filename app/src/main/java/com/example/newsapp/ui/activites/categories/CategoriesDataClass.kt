package com.example.newsapp.ui.activites.categories

import com.example.newsapp.R

data class CategoriesDataClass(
    var id:String,
    var name:String,
    var imageId:Int,
    var backgroundColorId:Int
){
    companion object{
        fun getCategories():List<CategoriesDataClass>{
            return listOf(
                CategoriesDataClass("general","General", R.drawable.ic_environment,R.color.lightblue),
                CategoriesDataClass("sports","Sports", R.drawable.ic_sports,R.color.red),
                CategoriesDataClass("entertainment","Entertainment", R.drawable.ic_politics,R.color.blue),
                CategoriesDataClass("health","Health", R.drawable.ic_health,R.color.pink),
                CategoriesDataClass("business","Business", R.drawable.ic_bussines,R.color.orange),
                CategoriesDataClass("science","Science", R.drawable.ic_science,R.color.yellow),
            )
        }
    }
}

