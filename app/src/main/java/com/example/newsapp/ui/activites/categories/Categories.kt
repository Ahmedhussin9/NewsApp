package com.example.newsapp.ui.activites.categories

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.newsapp.databinding.ActivityCategoriesBinding
import com.example.newsapp.Constnats
import com.example.newsapp.R
import com.example.newsapp.ui.activites.news.News

class Categories : AppCompatActivity() {
    lateinit var viewBinding:ActivityCategoriesBinding
    lateinit var viewModel: CategoriesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_categories)
        initViews()
        onClickListeners()
        loadCategories()
        subscribeToLiveData()
    }
    var categoreiesAdapter=CategoreiesAdapter(null)
    private fun initViews() {
        viewModel = ViewModelProvider(this)[CategoriesViewModel::class.java]
        viewBinding.recyclerView.adapter = categoreiesAdapter
    }
    private fun onClickListeners() {
        categoreiesAdapter.onCategoryClickListener=CategoreiesAdapter.OnCategoryClickListener {
                position, item ->
            viewModel.invokeAction(CategoriesContract.Action.OnCategoryClick(item))
        }
    }
    private fun subscribeToLiveData() {
        viewModel.catrgories.observe(this){
            categoreiesAdapter.bindItems(it)
        }
        viewModel.events.observe(this){
            when(it){
                is CategoriesContract.Events.NavigateToNews->navigateToNews(it.item)
            }
        }
    }
    private fun loadCategories() {
       viewModel.invokeAction(CategoriesContract.Action.LoadCategories())
    }
    private fun navigateToNews(item:CategoriesDataClass) {
        var intent =Intent(this,News::class.java)
        intent.putExtra(Constnats.EXTRA_CATEGORY_ID,item.id)
        startActivity(intent)
    }

}