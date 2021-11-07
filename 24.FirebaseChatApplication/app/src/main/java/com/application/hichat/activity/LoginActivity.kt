package com.application.hichat.activity

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.application.hichat.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private var auth: FirebaseAuth? = null
    private  var firebaseUser: FirebaseUser? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()
        //firebaseUser = auth!!.currentUser!!

        //check if user login then navigate to user screen
        if (firebaseUser != null) {
            val intent = Intent(
                this@LoginActivity,
                UserActivity::class.java
            )
            startActivity(intent)
            finish()
        }

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            if (TextUtils.isEmpty(email) && TextUtils.isEmpty(password)) {
                Toast.makeText(
                    applicationContext,
                    "email and password are required",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                auth!!.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) {
                        if (it.isSuccessful) {
                            etEmail.setText("")
                            etPassword.setText("")
                            val intent = Intent(
                                this@LoginActivity,
                                UserActivity::class.java
                            )
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(
                                applicationContext,
                                "email or password invalid",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            }
        }

        btnSignUp.setOnClickListener {
            val intent = Intent(
                this@LoginActivity,
                SignUpActivity::class.java
            )
            startActivity(intent)
            finish()
        }
    }
    /*
    private lateinit var auth: FirebaseAuth
    private lateinit var firebaseUser: FirebaseUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()
        firebaseUser = auth.currentUser!!

//        check if user login then navigate to user screen
        if (firebaseUser != null) {
            val intent = Intent(this@LoginActivity, UserActivity::class.java)
            startActivity(intent)
            finish()
        }
        loginButtonClicked()
        signUpButtonCLicked()
    }

    private fun signUpButtonCLicked() {
        btnSignUp.setOnClickListener {
            val intent = Intent(this@LoginActivity, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun loginButtonClicked() {
        btnLogin.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            if (TextUtils.isEmpty(email) && TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Cannot be empty", Toast.LENGTH_SHORT).show()
            } else {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) {
                        if (it.isSuccessful) {
                            etEmail.setText("")
                            etPassword.setText("")
                            val intent = Intent(this@LoginActivity, UserActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else
                            Toast.makeText(
                                this@LoginActivity,
                                "email id and password invalid",
                                Toast.LENGTH_SHORT
                            ).show()
                    }
            }
        }
    }
     */
}
