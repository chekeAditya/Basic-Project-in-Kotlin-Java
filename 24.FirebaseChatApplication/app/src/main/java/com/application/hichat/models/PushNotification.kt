package com.application.hichat.models

data class PushNotification(
    val data: NotificationDataModel,
    val to: String
)