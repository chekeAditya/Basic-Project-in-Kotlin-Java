package com.aditya.alarmmanager

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AlarmReceiver : BroadcastReceiver() {


    override fun onReceive(context: Context?, intent: Intent?) {

        /**Triggered when alarm goes off */
        if (intent?.action == "FOO_ACTION") {
            val fooString = intent.getStringExtra("KEY_FOO_STRING")
            Toast.makeText(context, fooString, Toast.LENGTH_SHORT).show()
        }
    }
}
/**
 *
 * BroadcastReceiver is a class for receiving and handling the broadcast sent to your application. In system alarm case, it receives broadcast from the system alarm service when alarm goes off. It has to be either registered dynamically in activity or statically declared at AndroidManifest.xml. The above codes show an example to register at AndroidManifest statically.
 *
 * The most important function to be overridden in a BroadcastReceiver is onReceive(). It is the place for receiving the broadcast sent from the system. Developer can manipulate the data bundled in the received Intent by using the getXXXExtra() functions.
 */