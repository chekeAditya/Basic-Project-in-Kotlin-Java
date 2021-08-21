package com.example.eventfragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_price_details.*

class PriceDetailsFragment : Fragment(R.layout.fragment_price_details) {

    private lateinit var title: String
    private lateinit var description: String
    private lateinit var startDate: String
    private lateinit var endDate: String
    private lateinit var startTime: String
    private lateinit var endTime: String
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getDataFromBundle()
    }

    private fun getDataFromBundle() {
        arguments?.run {
            title = getString("title")!!
            description = getString("description")!!
            startDate = getString("startDate")!!
            endDate = getString("endDate")!!
            startTime = getString("startTime")!!
            endTime = getString("endTime")!!
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btnPreview.setOnClickListener {
            val currency = etCurrency.text.toString()
            val price = etPrice.text.toString()

            //passing data in the activity
            val intent = Intent(context, PreviewActivity::class.java)
            intent.putExtra("title", title)
            intent.putExtra("description", description)
            intent.putExtra("startDate", startDate)
            intent.putExtra("endDate", endDate)
            intent.putExtra("startTime", startTime)
            intent.putExtra("endTime", endTime)
            intent.putExtra("price", price)
            startActivity(intent)
        }
    }


}