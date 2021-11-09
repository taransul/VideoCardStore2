package com.example.videocardstore2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*

class ModelViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

    companion object {
        fun from(parent: ViewGroup): ModelViewHolder {
            return ModelViewHolder(
                LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.item_layout, parent, false)
            )
        }
    }

    private val modelTextView: TextView by lazy { itemView.title }

    private var itemClickListener: ((VideoCardModelData) -> Unit)? = null

    fun bindView(item: VideoCardModelData) {
        modelTextView.text = item.model

        itemView.setOnClickListener {
            itemClickListener?.invoke(item)
        }
    }

    fun setItemClickListener(listener: ((VideoCardModelData) -> Unit)) {
        itemClickListener = listener
    }
}