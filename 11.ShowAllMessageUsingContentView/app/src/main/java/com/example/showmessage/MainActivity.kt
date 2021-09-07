package com.example.showmessage

import android.annotation.SuppressLint
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.Telephony
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lstSms: MutableList<MessageDTO> = ArrayList()
        recyclerView.layoutManager = LinearLayoutManager(this)

        callResponse(lstSms)
    }

    @SuppressLint("Range")
    private fun callResponse(lstSms: MutableList<MessageDTO>) {
        val cursor: Cursor? = contentResolver.query(
            Telephony.Sms.Inbox.CONTENT_URI, arrayOf(Telephony.Sms.Inbox.BODY),  // Select body text
            null,
            null,
            Telephony.Sms.Inbox.DEFAULT_SORT_ORDER
        ) // Default sort order


        while (cursor!!.moveToNext()) {
            val heading = cursor.getString(cursor.getColumnIndex(Telephony.Sms.Inbox.SUBJECT))
            val description = cursor.getString(cursor.getColumnIndex(Telephony.Sms.Inbox.BODY))
            val obj = MessageDTO()
            obj.description = description
            obj.heading = heading
            lstSms.add(obj)
        }
        cursor.close()
        recyclerView.adapter = MessageAdapter(lstSms)
        /**
         *
        val totalSMS: Int = cursor!!.count
        if (cursor.moveToFirst()) {
        for (i in 0 until totalSMS) {
        lstSms.add(cursor.getString(0))
        cursor.moveToNext()
        }
        } else {
        throw RuntimeException("You have no SMS in Inbox")
        }
        cursor.close()
        return lstSms
         */
    }
}