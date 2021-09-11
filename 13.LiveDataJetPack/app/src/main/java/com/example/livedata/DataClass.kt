package com.example.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class DataClass {

    private var apiDataVersion = 0;
    private var adDataVersion = 0;

    private val apiMutableData = MutableLiveData<String>()
    private val dbMutableLiveData = MutableLiveData<String>()
    private val mediatorLiveData = MediatorLiveData<String>()

    //setValue() - MainThread
    //postValue() - postvalue(newdata)

    fun getAPINewData() {
        apiDataVersion++ //new value should be updated.
        apiMutableData.value = "API response $apiDataVersion"
    }

    fun getDBNewData() {
        adDataVersion++ //incrementing this data.
        dbMutableLiveData.value = "DB data $adDataVersion"
    }

    fun getMediatorLiveData(): LiveData<String> {
        mediatorLiveData.addSource(apiMutableData, Observer {
            mediatorLiveData.value = it
        })
        mediatorLiveData.addSource(dbMutableLiveData, Observer {
            mediatorLiveData.value = it
        })

        return mediatorLiveData
    }

    /**
    //        getting data from API
    fun getApiData(): LiveData<String> {
    //        return "API response $apiDataVersion";
    return apiMutableData;
    }

    fun getDBData(): LiveData<String> {
    //        return "DB data $apiDataVersion";
    return dbMutableLiveData
    }
     */


}