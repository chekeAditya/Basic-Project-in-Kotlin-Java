package com.application.hichat.activity

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.application.hichat.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_signup.*

class SignUpActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        auth = FirebaseAuth.getInstance()
        btnSignUp.setOnClickListener {
            val userName = etName.text.toString()
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            val confirmPassword = etPassword.text.toString()

            if (TextUtils.isEmpty(userName) ||
                TextUtils.isEmpty(email) ||
                TextUtils.isEmpty(password) ||
                TextUtils.isEmpty(confirmPassword)
            ) {
                Toast.makeText(this, "can't be empty", Toast.LENGTH_SHORT).show()
            }

            if (password != confirmPassword) {
                Toast.makeText(this, "pass don't match", Toast.LENGTH_SHORT).show()
            }
            registerUser(userName, email, password)
        }

        btnLogin.setOnClickListener {
            val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun registerUser(userName: String, email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { it ->
                if (it.isSuccessful) {
                    val user: FirebaseUser? = auth.currentUser
                    val userId: String = user!!.uid

                    databaseReference = FirebaseDatabase.getInstance().getReference("Users")
                        .child(userId)
                    val hashMap: HashMap<String, String> = HashMap()

                    hashMap.put("userId", userId)
                    hashMap.put("userName", userName)
                    hashMap.put("profileImage", "")
                    databaseReference.setValue(hashMap).addOnCompleteListener(this) {
                        if (it.isSuccessful) {
                            //open home activity
                                etName.setText("")
                                etEmail.setText("")
                                etPassword.setText("")
                                etConfirmPassword.setText("")
                            var intent = Intent(this@SignUpActivity, UserActivity::class.java)
                            startActivity(intent)
                            finish()
                            Toast.makeText(
                                this@SignUpActivity,
                                "Successfully login",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } else
                    Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
            }
    }
}