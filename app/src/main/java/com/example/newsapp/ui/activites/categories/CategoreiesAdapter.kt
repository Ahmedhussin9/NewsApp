package com.example.newsapp.ui.activites.categories

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.databinding.CatergoryItemBinding

class CategoreiesAdapter(var categories:List<CategoriesDataClass>):RecyclerView.Adapter<CategoreiesAdapter.ViewHolder>() {
    class ViewHolder( var viewBinding:CatergoryItemBinding):RecyclerView.ViewHolder(viewBinding.root){
        fun bind(item:CategoriesDataClass){
            viewBinding.cat = item
            viewBinding.invalidateAll()
            viewBinding.catName.text = item.name
            viewBinding.catImage.setImageResource(item.imageId)
            viewBinding.layoutItem.setCardBackgroundColor(ContextCompat.getColor(viewBinding.root.context,item.backgroundColorId))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val viewBinding = CatergoryItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(viewBinding)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(categories[position])
    }
}