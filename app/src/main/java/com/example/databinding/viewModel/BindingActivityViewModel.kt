package com.example.databinding.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.databinding.model.ExamBinding
import com.example.databinding.repository.BindingActivityRepository

class BindingActivityViewModel:  ViewModel() {
    val SetterGetter = MutableLiveData<ExamBinding>()

    fun getUser()  {
        BindingActivityRepository.getServicesApiCall(SetterGetter)

    }

    fun getUserLiveData() : LiveData<ExamBinding>? {
        return SetterGetter

    }



}