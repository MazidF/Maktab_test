package com.example.newproject.data.network

import com.example.newproject.model.User
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface MyService {

    @POST("users")
    fun createUser(
        @Body user: User
    ) : Call<ResponseBody>

}