package com.example.updateanddelete

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.updateanddelete.Database.AdModel
import com.example.updateanddelete.Database.DbHandler
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dbHandler = DbHandler(this)
        val result = dbHandler.getAds()

        val adapter2 = SomeDataAdapter2()

        registerBtn.setOnClickListener {
            val title = titleEt.text.toString()
            val desc = descEt.text.toString()
            val price = priceEt.text.toString()

            val adModel = AdModel()
            adModel.title = title
            adModel.desc = desc
            adModel.price = price

            val isSuccess = dbHandler.savedAd(adModel)

            if (isSuccess) {
                Toast.makeText(this, "Ad publishes successfully", Toast.LENGTH_SHORT).show()
                titleEt.setText("")
                descEt.setText("")
                priceEt.setText("")
            } else {
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
            }

        }

    }
}