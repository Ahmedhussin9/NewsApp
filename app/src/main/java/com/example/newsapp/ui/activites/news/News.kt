package com.example.newsapp.ui.activites.news

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.domain.model.newsResponse.News
import com.example.domain.model.sourcesResponse.Source
import com.example.newsapp.databinding.ActivityNewsBinding
import com.example.newsapp.Constnats
import com.example.newsapp.R
import com.example.newsapp.ui.activites.article_details.ArticleDetails
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class News : AppCompatActivity() {
    lateinit var viewBinding:ActivityNewsBinding
    lateinit var viewModel: NewsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_news)
        initViews()
        initPrams()
        loadSources()
        observeLiveData()
        onArticleClick()
    }

    private fun onArticleClick() {
        adapter.onArticleClickListener=NewsAdapter.OnArticleClickListener(){
            position, item ->
            viewModel.invoke(NewsContract.Action.OnArticleClick(item))
        }
    }

    private fun navigateToArticleDetails(item: News) {
        val intent = Intent(this,ArticleDetails::class.java)
        intent.putExtra(Constnats.EXTRA_ARTICLE,item)
        startActivity(intent)
    }

    private fun loadSources() {
        viewModel.invoke(NewsContract.Action.GetNewsSources(CategoryId))
    }

    private fun observeLiveData() {
        viewModel.states.observe(this){
            when(it){
               is  NewsContract.State.SourcesSuccess->showSuccess(it.data)
                is NewsContract.State.ArticlesSuccess->showArticles(it.data)
                is NewsContract.State.Loading->showLoading()
                is NewsContract.State.Error->showError(it)
            }
        }
        viewModel.events.observe(this){
            when(it){
                is NewsContract.Event.NavigateToArticleDetails->navigateToArticleDetails(it.article)
            }
        }
    }

    private fun showArticles(data: List<News?>?) {
        viewBinding.content.successView.isVisible = true
        viewBinding.content.errorView.isVisible = false
        viewBinding.content.loadingView.isVisible = false
        adapter.bindNews(data)
    }

    private fun showSuccess(data: List<Source?>?) {
        viewBinding.content.successView.isVisible = true
        viewBinding.content.errorView.isVisible = false
        viewBinding.content.loadingView.isVisible = false
        bindTabs(data)
    }
    private val adapter = NewsAdapter()
    private fun initViews() {
        viewModel = ViewModelProvider(this)[NewsViewModel::class.java]
        viewBinding.vm=viewModel
        viewBinding.lifecycleOwner = this
        viewBinding.content.recyclerView.adapter = adapter
    }
    private var CategoryId :String?=null
    private fun initPrams() {
        CategoryId = intent.getStringExtra(Constnats.EXTRA_CATEGORY_ID)?:""
    }
    private fun showError(it: NewsContract.State.Error) {
        viewBinding.content.successView.isVisible = false
        viewBinding.content.errorView.isVisible = true
        viewBinding.content.loadingView.isVisible = false
        viewBinding.content.errorText.text = it.errorMessage
        viewBinding.content.tryAgainButton.setOnClickListener(){
            loadSources()
        }
    }
    private fun showLoading() {
        viewBinding.content.successView.isVisible = false
        viewBinding.content.errorView.isVisible = false
        viewBinding.content.loadingView.isVisible = true    }


    private fun bindTabs(source: List<Source?>?) {
        if (source==null)return
        source.forEach{source->
            val tab = viewBinding.content.tabLayout.newTab()
            tab.text = source?.name
            tab.tag = source
            viewBinding.content.tabLayout.addTab(tab)
        }
        viewBinding.content.tabLayout.addOnTabSelectedListener(
            object : TabLayout.OnTabSelectedListener{
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    val source = tab?.tag as Source
                    viewModel.invoke(NewsContract.Action.GetArticles(source.id))
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {
                    val source = tab?.tag as Source
                    viewModel.invoke(NewsContract.Action.GetArticles(source.id))
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {

                }
            }
        )
        viewBinding.content.tabLayout.getTabAt(0)?.select()
    }
    }