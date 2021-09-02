package com.example.searchfuncationality.Model


import com.google.gson.annotations.SerializedName

data class ResponseModel(
    @SerializedName("Indian Toons")
    val dataModels: List<DataModel>
)