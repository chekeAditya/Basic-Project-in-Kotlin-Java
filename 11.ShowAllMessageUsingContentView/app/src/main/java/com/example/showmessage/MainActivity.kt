package com.example.showmessage

import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.Telephony
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import android.content.ContentResolver
import android.net.Uri
import android.view.View
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import android.widget.TextView
import java.lang.RuntimeException


class MainActivity : AppCompatActivity() {


    var lstSms: MutableList<MessageDTO> = ArrayList()
    private lateinit var adapter: SimpleCursorAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val inboxURI = Uri.parse("content://sms/inbox")
        val reqCols = arrayOf("_id", "address", "body")
        val cr = contentResolver
        val c = cr.query(inboxURI, reqCols, null, null, null)

        // Attached Cursor with adapter and display in listview
        adapter = SimpleCursorAdapter(
            this, R.layout.row, c, arrayOf("body", "address"), intArrayOf(
                R.id.lblMsg, R.id.lblNumber
            )
        )
        lvMsg.adapter = adapter

    }


//    private fun getMessage() {
//        val c = cr.query(
//            Telephony.Sms.Inbox.CONTENT_URI, arrayOf(Telephony.Sms.Inbox.BODY),  // Select body text
//            null, null, Telephony.Sms.Inbox.DEFAULT_SORT_ORDER
//        )
//        val totalSMS = c!!.count
//
//        if (c!!.moveToFirst()) {
//            for (i in 0 until totalSMS) {
//                lstSms.add(c.getColumnIndex(i))
//                c.moveToNext()
//            }
//        } else {
//            throw RuntimeException("You have no SMS in Inbox")
//        }
//        c.close()
//        return lstSms
//    }

//    @SuppressLint("Range")
//    private fun callResponse(lstSms: MutableList<MessageDTO>): MutableList<MessageDTO> {
//        val cursor: Cursor? = this.contentResolver.query(
//            Telephony.Sms.Inbox.CONTENT_URI, arrayOf(Telephony.Sms.Inbox.BODY),  // Select body text
//            null,
//            null,
//            Telephony.Sms.Inbox.DEFAULT_SORT_ORDER
//        ) // Default sort order
//
//
//        val totalSMS: Int = cursor!!.count
//        if (cursor.moveToFirst()) {
//        for (i in 0 until totalSMS) {
//        lstSms.add(cursor.getString(0))
//        cursor.moveToNext()
//        }
//        } else {
//        throw RuntimeException("You have no SMS in Inbox")
//        }
//        cursor.close()
//        return lstSms
//         }


//        if (cursor != null && cursor.count > 0) {
//            cursor.moveToFirst()
//            do {
//                val heading = cursor.getString(cursor.getColumnIndex(Telephony.Sms.Inbox.SUBJECT))
//                val description = cursor.getString(cursor.getColumnIndex(Telephony.Sms.Inbox.BODY))
//                val obj = MessageDTO()
//                obj.description = description
//                obj.heading = heading
//                Log.d("Aditya", "$description")
//                lstSms.add(obj)
//            } while (cursor.moveToNext())
//            if (!cursor.isClosed) {
//                cursor.close()
//            }
//        } else {
//            Log.d("Aditya", "$lstSms")
////            recyclerView.adapter = MessageAdapter(lstSms)
//        }


}
