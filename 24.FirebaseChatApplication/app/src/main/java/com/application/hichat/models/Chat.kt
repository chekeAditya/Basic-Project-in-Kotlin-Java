package com.application.hichat.models

data class Chat(
    val senderId: String = "",
    val receiverId: String = "",
    val message: String = ""
)