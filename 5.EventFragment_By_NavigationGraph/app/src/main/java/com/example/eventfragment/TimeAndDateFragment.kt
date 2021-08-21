package com.example.eventfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_time_and_date.*

class TimeAndDateFragment : Fragment(R.layout.fragment_time_and_date) {

    private lateinit var title :String
    private lateinit var description: String
    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getDataFromBundle()
    }

    private fun getDataFromBundle() {
        arguments?.run {
            title = getString("title")!!
            description = getString("description")!!
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btnNextTimeDateFragment.setOnClickListener {
            val startDate = etEventStartDate.text.toString()
            val  endDate = etEventEndDate.text.toString()
            val startTime = etEventStartTime.text.toString()
            val endTime = etEventEndTime.text.toString()

            //passing data
            val bundle = Bundle()
            bundle.putString("title",title)
            bundle.putString("description",description)
            bundle.putString("startDate",startDate)
            bundle.putString("endDate",endDate)
            bundle.putString("startTime",startTime)
            bundle.putString("endTime",endTime)
            navController.navigate(
                R.id.action_timeAndDateFragment_to_priceDetailsFragment,bundle
            )
        }
    }

}