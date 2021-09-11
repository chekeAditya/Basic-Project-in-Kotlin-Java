package com.example.androidlivedata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_a.*


class FragmentA : Fragment(R.layout.fragment_a) {

    private val dataClass = DataClass()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        btnIncrementCountInFragA.setOnClickListener {
            dataClass.getFragmentACount()
        }

        dataClass.getMediatorLiveData().observe(viewLifecycleOwner, Observer {
            textCountFragA.text = it
        })
    }
}