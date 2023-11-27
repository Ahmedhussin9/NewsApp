package com.example.newsapp.ui.activites.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.newsapp.R
import com.example.newsapp.ui.activites.categories.Categories

class splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler(Looper.getMainLooper()).postDelayed({
                                                    val intent = Intent(this,Categories::class.java)
            startActivity(intent)
        },2000)
    }
}