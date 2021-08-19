package com.example.fetchdata.Interface

import com.example.fetchdata.Model.ResponseDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {

    @GET("/api/users/{Id}")
    fun getUserDetails(@Path("Id") id: Int): Call<ResponseDTO>
}