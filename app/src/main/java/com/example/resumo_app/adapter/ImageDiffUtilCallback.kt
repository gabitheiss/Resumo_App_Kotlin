package com.example.resumo_app.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.resumo_app.model.Image

class ImageDiffUtilCallback : DiffUtil.ItemCallback<Image>() {

    override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }
}