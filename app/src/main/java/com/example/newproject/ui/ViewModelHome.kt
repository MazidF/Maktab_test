package com.example.newproject.ui

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newproject.data.network.NetworkManager.service
import com.example.newproject.model.User
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response

class ViewModelHome : ViewModel() {
    val failed by lazy {
        MutableLiveData(false)
    }

    fun createUser(user: User) {
        val call = service.createUser(user)
        call.enqueue(object : retrofit2.Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                val id = response.body()?.string() ?: "-1"
                Log.d("response_id", id)
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                failed.postValue(true)
            }
        })
    }
}