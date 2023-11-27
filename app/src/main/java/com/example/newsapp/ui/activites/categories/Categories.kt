package com.example.newsapp.ui.activites.categories

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.newsapp.R
import com.example.newsapp.databinding.ActivityCategoriesBinding

class Categories : AppCompatActivity() {
    lateinit var viewBinding:ActivityCategoriesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this,R.layout.activity_categories)
        initViews()
    }
    var categoreiesAdapter = CategoreiesAdapter(CategoriesDataClass.getCategories())
    private fun initViews() {
        viewBinding.recyclerView.adapter = categoreiesAdapter
    }
}