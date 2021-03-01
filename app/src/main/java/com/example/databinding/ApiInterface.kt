package com.example.databinding

import com.example.databinding.model.BindingModel
import com.example.databinding.model.ExamBinding

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("facts.json")
    fun getRows() : Call<ExamBinding>


}