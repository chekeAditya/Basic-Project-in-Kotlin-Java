package com.example.databinding.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.databinding.remote.APIClient
import com.example.databinding.remote.response.ResultModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class Repository @Inject constructor(private val apiClient: APIClient) {
    suspend fun getResponse(): List<ResultModel> {
        return  apiClient.getAPIResponse().resultModels
    }
}