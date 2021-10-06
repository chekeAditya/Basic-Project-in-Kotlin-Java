package com.example.databinding.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.databinding.remote.Resource
import com.example.databinding.remote.response.PopularMovies
import com.example.databinding.remote.response.ResultModel
import com.example.databinding.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModelMovies @Inject constructor(val repository: Repository) : ViewModel() {

    fun getDataFromAPI() : LiveData<List<ResultModel>>{
        return repository.getResponse()
    }
}