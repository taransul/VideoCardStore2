package com.example.videocardstore2

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ModelAdapter : RecyclerView.Adapter<ModelViewHolder>() {

    private var items: List<Model> = mutableListOf()

    private var itemClickListener: ((Model) -> Unit)? = null

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

    fun submitList(data: List<Model>) {
        items = data
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(listener: (Model) -> Unit) {
        itemClickListener = listener
    }
}