package com.example.resumo_app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.resumo_app.R
import com.example.resumo_app.databinding.ItensListBinding
import com.example.resumo_app.model.ImageModel

class AdapterImages : ListAdapter<ImageModel, ImageViewHolder>(ImageDiffUtilCallback()) {

    val listOfImages = mutableListOf<ImageModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.itens_list, parent, false).apply {
            return ImageViewHolder(this)
        }

    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        getItem(position).let { image ->
            holder.bind(image)
        }
    }

    fun update(newList: List<ImageModel>, clear: Boolean = false) {
        if (clear) {
            listOfImages.clear()
        }
        listOfImages.addAll(newList)
        submitList(listOfImages.toMutableList())
    }

}


class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val binding = ItensListBinding.bind(itemView)

    fun bind(imageModel: ImageModel) {
        Glide.with(itemView)
            .load(imageModel.largeImageURL)
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.imageViewFeed)
    }

}