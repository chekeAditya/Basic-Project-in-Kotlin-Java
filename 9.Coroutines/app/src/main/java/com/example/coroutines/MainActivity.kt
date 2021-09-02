package com.example.coroutines

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    val TAG = "coroutines_tag"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.tvTextView)

        /**
         * Run blocking
         */
        runBlocking {

        }

//        CoroutineScope(Dispatchers.Main).launch {
//            Toast.makeText(this@MainActivity, "Main", Toast.LENGTH_SHORT).show()
//        }

        //Create a couroutine
//        now launch will create a coroutine inside IO
        val job = CoroutineScope(Dispatchers.IO).launch {
            Log.d(TAG, "FROM Launch")
//            val data = getApiData()
//            Log.d(TAG, "$data")
//            Toast.makeText(this@MainActivity, "IO", Toast.LENGTH_SHORT).show()


            /**
             * Async Await
             */
            var d = async {
                val data = getApiData()
                return@async data
            }.await()

            val newValue = async {
                d = "yes"
                val data = getApiData()
                return@async "new data"
            }.await()


            CoroutineScope(Dispatchers.Main).launch {
                textView.text = newValue
            }
        }

        val job2 = CoroutineScope(Dispatchers.IO).launch {
            Log.d(TAG,"Job")
        }


        /**
            IO -> I/p Thread, Main -> Main Thread
            launch is a builder it will actuall
         */
//        CoroutineScope(Dispatchers.Default).launch {
//            getApiData()
//            Toast.makeText(this@MainActivity, "Default", Toast.LENGTH_SHORT).show()
//        }
    }

    suspend fun getApiData(): String {
        //here it will just give a delay of 3sec
        delay(3000)
        return "Api response arrived"
    }
}

/**
 * launch, async,
 */