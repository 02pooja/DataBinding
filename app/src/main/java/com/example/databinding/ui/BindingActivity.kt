package com.example.databinding.ui


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Context
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.databinding.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import com.example.databinding.R
import com.example.databinding.adapter.BindingAdapter
import com.example.databinding.databinding.ActivityBindingBinding
import com.example.databinding.model.BindingModel
import com.example.databinding.viewModel.BindingActivityViewModel
import com.example.databinding.viewModel.DataBindingModel
import kotlinx.android.synthetic.main.activity_binding.*

class BindingActivity : AppCompatActivity(), BindingAdapter.OnItemClickListener<Any> {
     lateinit var binding: ActivityBindingBinding
     lateinit var madapter: BindingAdapter<Any ?>
      lateinit var viewModel: BindingActivityViewModel
    lateinit var rview:RecyclerView
    lateinit var context: Context
    var mlist = listOf<BindingModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView(this, R.layout.activity_binding)
        context = this@BindingActivity
       // adapter = DataAdpter(mlist, this)

        init()
        getData()

    }


    private fun init() {
        viewModel = ViewModelProvider(this).get(BindingActivityViewModel::class.java)


    }
   private fun getData() {

               viewModel.getUser()!!.observe(this, Observer {
                   binding.rView!!.layoutManager = LinearLayoutManager(this)
                   binding.rView.adapter = madapter

        madapter = BindingAdapter<Any?>(
            mlist,
            this,
            R.layout.row_item
        )

            })
    }



    override fun onItemClick(view: View?, position: Int, `object`: Any?) {
        TODO("Not yet implemented")
    }


}