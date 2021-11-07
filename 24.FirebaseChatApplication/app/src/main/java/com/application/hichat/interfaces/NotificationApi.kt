package com.application.hichat.interfaces

import com.application.hichat.constants.Constants.CONTENT_TYPE
import com.application.hichat.constants.Constants.SERVER_KEY
import com.application.hichat.models.PushNotification
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface NotificationApi {

    @Headers("Authorization: key=$SERVER_KEY","Content-type:$CONTENT_TYPE")
    @POST("fcm/send")
    suspend fun postNotification(
        @Body notification: PushNotification
    ): Response<ResponseBody>
}