package com.example.newsapp

import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("url")
fun bindImageWithUrl(imageView: ImageView,url:String){
    Glide.with(imageView).load(url).into(imageView)
}