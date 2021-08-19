package com.example.fetchdata.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.fetchdata.Interface.ApiClient
import com.example.fetchdata.Model.ResponseDTO
import com.example.fetchdata.R
import kotlinx.android.synthetic.main.fragment_user_details.*
import retrofit2.Call
import retrofit2.Callback
import com.example.fetchdata.Network
import retrofit2.Response

class UserDetailsFragment : Fragment(R.layout.fragment_user_details) {

    private lateinit var responseDTO: ResponseDTO

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnCallApi.setOnClickListener {
            callApi()
        }
    }

    private fun callApi() {
        val apiClient = Network.getRetrofitInstance().create(ApiClient::class.java)
        apiClient.getUserDetails(2).enqueue(object : Callback<ResponseDTO> {
            override fun onResponse(call: Call<ResponseDTO>, response: Response<ResponseDTO>) {
                response.body()?.run {
                    responseDTO = this
//                    tvFirstName.text = responseDTO.data.firstName
//                    tvLastName.text = responseDTO.data.lastName
                    responseDTO.data?.apply {
                        tvFirstName.text = firstName
                        tvLastName.text = lastName
                    }
                }
            }

            override fun onFailure(call: Call<ResponseDTO>, t: Throwable) {

            }

        })
    }
}