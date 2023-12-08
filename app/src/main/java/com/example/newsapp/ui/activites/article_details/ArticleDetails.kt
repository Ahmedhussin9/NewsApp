package com.example.newsapp.ui.activites.article_details

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.domain.model.newsResponse.News
import com.example.newsapp.Constnats
import com.example.newsapp.R
import com.example.newsapp.databinding.ActivityArticleDetailsBinding

class ArticleDetails : AppCompatActivity() {
    private lateinit var viewBinding:ActivityArticleDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this,R.layout.activity_article_details)
        initParmas()
        initViews()
    }

    private fun initViews() {
        viewBinding.content.articleTittle.text = article?.title
        Glide.with(viewBinding.content.articleImage).load(article?.urlToImage).into(viewBinding.content.articleImage)
        viewBinding.content.articletime.text = article?.publishedAt
        viewBinding.content.sourceText.text = article?.source?.name
        viewBinding.content.contentText.text = article?.content
        viewBinding.articleTitle.text = article?.title
        viewBinding.content.viewFullArticleButton.setOnClickListener(){
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(article?.url))
            viewBinding.content.viewFullArticleButton.context.startActivity(intent)
        }
    }

    var article:News?=null
    private fun initParmas() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            article =intent.getParcelableExtra(Constnats.EXTRA_ARTICLE,News::class.java)
        }else{
            article = intent.getParcelableExtra(Constnats.EXTRA_ARTICLE) as News?
        }
    }

}