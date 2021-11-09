package com.example.videocardstore2

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ModelAdapter : RecyclerView.Adapter<ModelViewHolder>() {

    private var items: List<VideoCardModelData> = mutableListOf()

    private var itemClickListener: ((VideoCardModelData) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        val viewHolder = ModelViewHolder.from(parent)
        viewHolder.setItemClickListener { model ->
            itemClickListener?.invoke(model)
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
        holder.bindView(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(data: List<VideoCardModelData>) {
        items = data
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(listener: (VideoCardModelData) -> Unit) {
        itemClickListener = listener
    }
}