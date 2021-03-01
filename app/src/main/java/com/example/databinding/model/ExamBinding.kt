package com.example.databinding.model


import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class ExamBinding {
    @SerializedName("title")
    @Expose
    private var title: String? = null

    val rows: List<BindingModel>? = null
}