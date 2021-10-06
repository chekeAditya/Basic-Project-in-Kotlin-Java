package com.example.loginsignup.network

import retrofit2.http.Field
import retrofit2.http.POST
import retrofit2.http.FormUrlEncoded

interface AuthApi {

    @FormUrlEncoded
    @POST("auth/login")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String,
        ): Any

}