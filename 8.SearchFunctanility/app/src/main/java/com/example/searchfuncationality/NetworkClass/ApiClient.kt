package com.example.searchfuncationality.NetworkClass

import com.example.searchfuncationality.Model.ResponseModel
import retrofit2.http.GET

interface ApiClient {
    @GET("v3/0404dd7e-c1ba-4669-b14b-3331f46741ec")
    fun getIndianToons(): retrofit2.Call<ResponseModel>
}