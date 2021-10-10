package com.example.databinding.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.databinding.remote.response.ResultModel
import com.example.databinding.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class ViewModelMovies @Inject constructor(val repository: Repository) : ViewModel() {

    fun getDataFromAPI() : LiveData<List<ResultModel>>{
        return liveData(Dispatchers.IO,1000){
            emit(repository.getResponse())
        }
    }
}