package com.example.taskmanagerapicalling.views.adapter

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


/**
 * Until you application is alive this class will be alive
 * Application class ( if anything needed through the application then you can write it here )
 */

@HiltAndroidApp
class TaskApp : Application() {

}