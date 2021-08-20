package com.example.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentController
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_choose_recipient.*
import kotlinx.android.synthetic.main.fragment_specific_amount.*

class FragmentSpecificAmount : Fragment(R.layout.fragment_specific_amount) {

    private var recipientName = ""
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipientName = arguments?.getString("recipentName")!! //this simply means that it will never be null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            navController = Navigation.findNavController(view)
        btnSend.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("name",recipientName)
            bundle.putInt("amount",etAmount.toString().toInt())
          navController.navigate(R.id.action_fragmentSpecificAmount_to_fragmentConfirmation2,bundle)
        }
    }
}