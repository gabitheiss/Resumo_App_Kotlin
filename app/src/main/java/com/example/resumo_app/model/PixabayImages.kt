package com.example.resumo_app.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class PixabayImages(

    @SerializedName("hits") val hits : List<ImageModel>
)

@Entity
data class ImageModel(
    @PrimaryKey
    val id : Int,
    val tags: String,
    val likes: Int,
    val previewURL: String?,
    val largeImageURL: String?,
    val fullHDURL: String?,
    val imageURL: String?,
    val user: String,
    val userImageURL: String,
)
