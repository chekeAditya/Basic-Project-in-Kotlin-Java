package com.example.eventfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_preview.*

class PreviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)
        getDataFromIntent()
    }

    private fun getDataFromIntent() {
        intent?.run {
            tvEventTitle.text = getStringExtra("title")
            tvEventDesc.text = getStringExtra("description")
            tvEventStartDate.text = getStringExtra("startDate")
            tvEventEndDate.text = getStringExtra("endDate")
            tvStartTime.text = getStringExtra("startTime")
            tvEndTime.text = getStringExtra("endTime")
            tvPrice.text = getStringExtra("price")
        }
    }
}