package com.example.newsapp.ui.activites.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newsapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class News : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
    }
}