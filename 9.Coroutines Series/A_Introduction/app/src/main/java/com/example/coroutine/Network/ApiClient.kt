package com.example.coroutine.Network

import com.example.coroutine.Model.RomanticMoviesResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiClient {
    //https://run.mocky.io/v3/5b7ee441-85e8-4cc8-95dc-da056caccdcd

// without coroutine where function is not a suspend function
//    @GET("v3/5b7ee441-85e8-4cc8-95dc-da056caccdcd")
//    fun getRomanticMovies() :Call<RomanticMoviesResponse>


    //    With coroutine
    @GET("v3/5b7ee441-85e8-4cc8-95dc-da056caccdcd")
    suspend fun getRomanticMovies(): Response<RomanticMoviesResponse>

    companion object {

        private val httpLoggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        operator fun invoke(): ApiClient {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://run.mocky.io/")
                .client(OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build())
                .build()
                .create(ApiClient::class.java)
        }
    }
}

/**
 * Making it as a suspend function and also change the return types from call to response
 * if you are not able to see the response in Response then check the version of Retrofit it should be above 2.6
 * From 2.6 kotlin allows to use Coroutines
 */