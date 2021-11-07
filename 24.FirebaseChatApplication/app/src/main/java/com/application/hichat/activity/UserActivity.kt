package com.application.hichat.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.application.hichat.R
import com.application.hichat.adapters.UserAdapter
import com.application.hichat.firebase.FirebaseService
import com.application.hichat.models.User
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.activity_user.*

class UserActivity : AppCompatActivity() {

    var userList = ArrayList<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        FirebaseService.sharedPref = getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
       

        userRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        imgBack.setOnClickListener {
            onBackPressed()
        }

        imgProfile.setOnClickListener {
            val intent = Intent(
                this@UserActivity,
                ProfileActivity::class.java
            )
            startActivity(intent)
        }
        getUsersList()
    }

    fun getUsersList() {
        val firebase: FirebaseUser = FirebaseAuth.getInstance().currentUser!!

        var userid = firebase.uid
        FirebaseMessaging.getInstance().subscribeToTopic("/topics/$userid")


        val databaseReference: DatabaseReference =
            FirebaseDatabase.getInstance().getReference("Users")


        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(applicationContext, error.message, Toast.LENGTH_SHORT).show()
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                userList.clear()
                val currentUser = snapshot.getValue(User::class.java)
                if (currentUser!!.profileImage == "") {
                    imgProfile.setImageResource(R.drawable.aditya_pic)
                } else {
                    Glide.with(this@UserActivity).load(currentUser.profileImage).into(imgProfile)
                }

                for (dataSnapShot: DataSnapshot in snapshot.children) {
                    val user = dataSnapShot.getValue(User::class.java)

                    if (!user!!.userId.equals(firebase.uid)) {

                        userList.add(user)
                    }
                }

                val userAdapter = UserAdapter(this@UserActivity, userList)

                userRecyclerView.adapter = userAdapter
            }

        })
    }
}