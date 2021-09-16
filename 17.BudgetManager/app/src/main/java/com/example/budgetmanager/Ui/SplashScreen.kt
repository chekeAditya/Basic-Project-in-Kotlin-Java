package com.example.budgetmanager.Ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.budgetmanager.R

class SplashScreen : AppCompatActivity() {

    var handler: Handler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        handler = Handler()
        handler!!.postDelayed({
            val intent = Intent(this@SplashScreen, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}