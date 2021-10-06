package com.example.loginsignup.network

import android.net.Network
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteDataSource {

    companion object{
        private const val BASE_URL = "http://13.232.169.202:8080/users/"
    }

    //it will be a generic function
    fun <Api> buildApi(
        api: Class<Api>
    ): Api {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }
}