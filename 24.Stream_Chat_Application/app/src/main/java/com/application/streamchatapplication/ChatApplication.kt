package com.application.streamchatapplication

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import io.getstream.chat.android.client.ChatClient
import io.getstream.chat.android.livedata.ChatDomain
import javax.inject.Inject

@HiltAndroidApp
class ChatApplication : Application() {

    @Inject
    lateinit var client: ChatClient

    //    here we are telling to the stream hey Stream now we are ready to use
    override fun onCreate() {
        super.onCreate()
        ChatDomain.Builder(client, applicationContext).build()
    }
}
/*
Client -> we will use this so many time in this application
       -> it's use is to make all the request to the servers so that stream server know which type of data they had to send or request
 */