package com.example.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class DataClass {

    private var apiDataVersion = 0;
    private var adDataVersion = 0;

    private val apiMutableData = MutableLiveData<String>()
    private val dbMutableLiveData =  MutableLiveData<String>()

    fun getAPINewData(){
        apiDataVersion++ //new value should be updated.
        apiMutableData.value = "API response $apiDataVersion"
    }

    fun getDBNewData(){
        apiDataVersion++ //incrementing this data.
        dbMutableLiveData.value = "DB data $apiDataVersion";
    }

//        getting data from API
    fun getApiData(): LiveData<String> {
//        return "API response $apiDataVersion";
        return apiMutableData;
    }

    fun getDBData(): LiveData<String> {
//        return "DB data $apiDataVersion";
        return dbMutableLiveData
    }
}