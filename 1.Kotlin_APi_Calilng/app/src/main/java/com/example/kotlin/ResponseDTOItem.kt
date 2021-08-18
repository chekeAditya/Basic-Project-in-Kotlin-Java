package com.example.kotlin

import com.google.gson.annotations.SerializedName

data class ResponseDTOItem(
    @SerializedName("body")
    val body: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("postId")
    val postId: Int?
)
/*
data class is the class which will had all the getter, setter , toString, methods inBuilt
 */