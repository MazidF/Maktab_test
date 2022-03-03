package com.example.newproject.data.network

import com.example.newproject.model.User
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface MyService {

    @POST("users")
    fun createUser(
        @Body user: User
    ) : Call<String>

    @Multipart
    @POST("users/{id}/image")
    fun uploadImage(@Path("id")id:String,
    @Part image : MultipartBody.Part): Call<Any>

}