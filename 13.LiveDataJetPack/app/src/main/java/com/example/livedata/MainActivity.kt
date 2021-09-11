package com.example.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val dataClass = DataClass()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiBtn.setOnClickListener {
            /**
            dataClass.getAPINewData() //incrementing the data
            val data =
                dataClass.getApiData() //manually i am calling this and asked him to get the data
            updateTextView(data)
            */
            dataClass.getAPINewData()
        }

        dbBtn.setOnClickListener {
            /**
            dataClass.getDBNewData() //data changed
            val data = dataClass.getDBData()
            updateTextView(data)
            */
            dataClass.getDBNewData()
        }
        //whenever data get changes it will also update it's just one time setup
        dataClass.getApiData().observe(this, Observer {
            val data = it
            textView.text = data
        })

        dataClass.getDBData().observe(this, Observer {
            val data = it
            textView.text = it
        })
    }

    fun updateTextView(newData: String) {
        textView.text = newData
    }
}