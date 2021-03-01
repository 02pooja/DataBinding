package com.example.databinding.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.gson.annotations.SerializedName


data class BindingModel(
    @SerializedName("title")
    val title: String?=null,

    @SerializedName("description")
    val description: String?=null,

    @SerializedName("imageHref")
    val imageHref: String?=null



)

