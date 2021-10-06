package com.example.taskmanagerapicalling.models.remote.responses.getTasksResponse


import com.google.gson.annotations.SerializedName

data class GetTasksResponseModelItem(
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("owner")
    val owner: String,
    @SerializedName("status")
    val status: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("updatedAt")
    val updatedAt: String,
    @SerializedName("__v")
    val v: Int
)