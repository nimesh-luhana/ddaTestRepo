package com.dda

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dda.databinding.RowNewsBinding

class NewsListAdapter(var newsList: List<NewsDetails>,val onItemClick: (Int) -> Unit) :
    RecyclerView.Adapter<NewsListAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            RowNewsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount() = newsList.size

    inner class NewsViewHolder(private val binding: RowNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener { onItemClick(adapterPosition) }
        }
        fun onBind(position: Int) {
            if (!newsList[position].media.isEmpty())
                ImageUtil.displayImage(
                    newsList[position].media[0].mediaMetaDataList[1].url,
                    binding.bannerImageView
                )
            binding.titleImageView.text = newsList[position].title
        }
    }
}