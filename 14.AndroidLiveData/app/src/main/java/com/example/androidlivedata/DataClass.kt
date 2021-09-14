package com.example.androidlivedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class DataClass {


    private var fragACount = 0;
    private var fragBCount = 0;


    private val fragmentAMutableData = MutableLiveData<String>()
    private val fragmentBMutableData = MutableLiveData<String>()

    private val mediatorLiveData = MediatorLiveData<String>()


    fun getFragmentACount() {
        fragACount++
        fragmentAMutableData.value = "Incrementing Count By : $fragACount"
    }

    fun getFragmentBCount() {
        fragBCount++
        fragmentBMutableData.value = "Incrementing Count By : $fragBCount"
    }

    fun getMediatorLiveData(): LiveData<String> {
        mediatorLiveData.addSource(fragmentAMutableData, Observer {
            mediatorLiveData.value = it
        })

        mediatorLiveData.addSource(fragmentBMutableData, Observer {
            mediatorLiveData.value = it
        })
        return mediatorLiveData
    }
}
/*
Types of LiveData :-
1.Mutable livedata
2.ImMutable livedata
3.Mediator livedata
 */