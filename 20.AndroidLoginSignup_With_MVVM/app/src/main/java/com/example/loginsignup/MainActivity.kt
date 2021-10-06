package com.example.loginsignup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loginsignup.ui.auth.AuthActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        finish()
        startActivity(Intent(this,AuthActivity::class.java))
    }
}