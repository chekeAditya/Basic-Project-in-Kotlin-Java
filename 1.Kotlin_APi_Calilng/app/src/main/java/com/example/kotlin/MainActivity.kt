package com.example.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var responseList : ResponseDTO
//    private var name: String? = null //if we write the question mark then it means list can be null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnPost.setOnClickListener {
            callApi()
        }
    }

    private fun callApi() {
        val apiClient = Network.getRetrofitInstance().create(ApiClient::class.java)
        apiClient.getPosts(etPostId.text.toString().toInt())
            .enqueue(object : Callback<ResponseDTO>{
                override fun onResponse(call: Call<ResponseDTO>, response: Response<ResponseDTO>) {
                    responseList = response.body()!! //nut null assertion, when we write !! then you should be 100% sure it won't be nullable
                    setRecyclerView()
                }

                override fun onFailure(call: Call<ResponseDTO>, t: Throwable) {
                }

            })
    }

    private fun setRecyclerView() {
        val postAdapter = PostAdapter(responseList)
        val linearLayouManager = LinearLayoutManager(this)
        recyclerView.adapter = postAdapter
        recyclerView.layoutManager = linearLayouManager
    }
}