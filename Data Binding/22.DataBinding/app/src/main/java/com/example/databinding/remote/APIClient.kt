package com.example.databinding.remote

import com.example.databinding.remote.response.PopularMovies
import com.example.databinding.remote.response.ResultModel
import retrofit2.http.GET

interface APIClient {

    @GET("movie/popular/?api_key=2147294b386ecadcb05cd19bcbbdddb9")
    suspend fun getAPIResponse(): PopularMovies

//    @GET("gistfile1.txt")
//    suspend fun getAPIResponse(): PopularMovies

}