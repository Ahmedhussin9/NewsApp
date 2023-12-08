package com.example.newsapp.ui.activites.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.newsResponse.News
import com.example.newsapp.databinding.ItemNewsBinding

class NewsAdapter(var newsList:List<com.example.domain.model.newsResponse.News?>?=null):RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    class ViewHolder(var viewBinding:ItemNewsBinding):RecyclerView.ViewHolder(viewBinding.root){
        fun bind(news: com.example.domain.model.newsResponse.News?){
            viewBinding.news  = news
            viewBinding.invalidateAll()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(viewBinding)
    }

    override fun getItemCount(): Int = newsList?.size ?:0


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val news = newsList!![position]
        holder.bind(news)
        if (onArticleClickListener!=null){
            holder.viewBinding.root.setOnClickListener(){
                newsList!![position]?.let { it1 ->
                    onArticleClickListener?.onItemClick(position,
                        it1
                    )
                }
            }
        }
    }
     var onArticleClickListener:OnArticleClickListener?=null
    fun interface OnArticleClickListener{
        fun onItemClick(position: Int,item:News)
    }
    fun bindNews(articles: List<News?>?) {
        newsList = articles
        notifyDataSetChanged()
    }
}