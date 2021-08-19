package com.example.fetchdata.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fetchdata.R
import com.example.fetchdata.Fragment.UserDetailsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        launchFragment()
    }

    private fun launchFragment() {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.flContainer, UserDetailsFragment(), "UserDetailsFragment")
            .commit()
    }
}