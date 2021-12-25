package com.aditya.alarmmanager

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

@RequiresApi(Build.VERSION_CODES.M)
class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Get AlarmManger instance
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

        //Intent Part (Prepare for an Intent)
        val intent = Intent(this, AlarmReceiver::class.java)
        intent.action = "FOO_ACTION"
        intent.putExtra("KEY_FOO_STRING", "Medium AlarmManager Demo")
        val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0)


        //Alarm Time
        val ALARM_DELAY_IN_SECOND = 10
        val alarmTimeAtUTC = System.currentTimeMillis() + ALARM_DELAY_IN_SECOND * 1_000L

        //Set With system Alarm Service
        // Other possible functions: setExact() / setRepeating() / setWindow(), etc
        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            alarmTimeAtUTC,
            pendingIntent
        )
        val alarmTime = System.currentTimeMillis() + 4000
        val tagStr = "TAG"
        val handler = null
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, alarmTime, tagStr,
            object : AlarmManager.OnAlarmListener {
                override fun onAlarm() {
                    Toast.makeText(
                        this@MainActivity,
                        "AlarmManager.OnAlarmListener",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }, null
        )

    }
}