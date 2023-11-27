package com.example.newsapp.ui

import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter

@BindingAdapter("imageId")
fun loadImageByIdDrawable(imageView: ImageView,image:Int){
    imageView.setImageResource(image)
}
@BindingAdapter("backGroundColor")
fun changeCardViewBackGround(cardView: CardView,color:Int){
    cardView.setBackgroundColor(ContextCompat.getColor(cardView.context,color))
}