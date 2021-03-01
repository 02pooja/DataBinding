package com.example.databinding.repository


import com.example.databinding.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.databinding.model.ExamBinding

object BindingActivityRepository {

    val serviceSetterGetter = MutableLiveData<ExamBinding>()

    fun getServicesApiCall(servicesLiveData: MutableLiveData<ExamBinding>?) {

        val call = ApiClient.apiInterface.getRows()

        call.enqueue(object: Callback<ExamBinding> {
            override fun onFailure(call: Call<ExamBinding>, t: Throwable) {
                // TODO("Not yet implemented")
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                    call: Call<ExamBinding>,
                    response: Response<ExamBinding>
            ) {
                // TODO("Not yet implemented")
                Log.v("DEBUG : ", response.body().toString())

              //  val data = response.body()

              //  val msg = data!!.Row

               // Log.e("ERREoe",msg.toString())
                servicesLiveData?.value = response.body()


            }
        })


    }
}