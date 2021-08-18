package com.example.kotlin

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("comments")
    fun getPosts(@Query("postId") postId : Int): Call<ResponseDTO>

}