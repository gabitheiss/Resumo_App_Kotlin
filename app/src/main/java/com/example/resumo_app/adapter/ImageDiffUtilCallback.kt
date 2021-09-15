package com.example.resumo_app.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.resumo_app.model.ImageModel

class ImageDiffUtilCallback : DiffUtil.ItemCallback<ImageModel>() {

    override fun areItemsTheSame(oldItem: ImageModel, newItem: ImageModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ImageModel, newItem: ImageModel): Boolean {
        return oldItem == newItem
    }
}