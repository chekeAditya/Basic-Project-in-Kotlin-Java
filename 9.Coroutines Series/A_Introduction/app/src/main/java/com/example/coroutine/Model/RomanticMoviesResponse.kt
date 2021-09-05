package com.example.coroutine.Model


import com.google.gson.annotations.SerializedName

data class RomanticMoviesResponse(
    @SerializedName("data")
    val `data`: List<DataResponse>
)