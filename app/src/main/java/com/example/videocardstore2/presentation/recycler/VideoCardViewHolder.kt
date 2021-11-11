package com.example.videocardstore2.presentation.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.videocardstore2.R
import kotlinx.android.synthetic.main.item_layout.view.*

class VideoCardViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

    companion object {
        fun from(parent: ViewGroup): VideoCardViewHolder {
            return VideoCardViewHolder(
                LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.item_layout, parent, false)
            )
        }
    }

    private val modelTextView: TextView by lazy { itemView.title }
    private var itemClickListener: ((VideoCard) -> Unit)? = null

    fun bindView(item: VideoCard) {
        modelTextView.text = item.model

        itemView.setOnClickListener {
            itemClickListener?.invoke(item)
        }
    }

    fun setItemClickListener(listener: ((VideoCard) -> Unit)) {
        itemClickListener = listener
    }
}