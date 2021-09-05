package com.example.coroutine.Network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network {

//    companion object {
//        private val httpLoggingInterceptor =
//            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
//
//       operator fun getInstance(): ApiClient {
//            return Retrofit.Builder()
//                .baseUrl("https://run.mocky.io/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build())
//                .build()
//                .create(ApiClient::class.java)
//        }
//    }
}