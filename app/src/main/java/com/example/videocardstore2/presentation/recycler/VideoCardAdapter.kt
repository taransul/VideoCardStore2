package com.example.videocardstore2.presentation.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class VideoCardAdapter : RecyclerView.Adapter<VideoCardViewHolder>() {

    private var items: List<VideoCard> = mutableListOf()
    private var itemClickListener: ((VideoCard) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoCardViewHolder {
        val viewHolder = VideoCardViewHolder.from(parent)
        viewHolder.setItemClickListener { model ->
            itemClickListener?.invoke(model)
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: VideoCardViewHolder, position: Int) {
        holder.bindView(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(data: List<VideoCard>) {
        items = data
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(listener: (VideoCard) -> Unit) {
        itemClickListener = listener
    }
}