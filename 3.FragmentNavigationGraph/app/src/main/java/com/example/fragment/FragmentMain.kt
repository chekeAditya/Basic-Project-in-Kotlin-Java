package com.example.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentController
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_framgment_main.*

class FragmentMain : Fragment(R.layout.fragment_framgment_main), View.OnClickListener {

    private lateinit var navigationController: NavController //lateinit means i don't know what to init but i will init later

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        navigationController = Navigation.findNavController(view)
    }

    private fun initListeners() {
        btnViewBalance.setOnClickListener(this)
        btnSendMoney.setOnClickListener(this)
        btnViewBalance.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnViewTransaction -> {
                navigationController.navigate(R.id.action_fragmentMain_to_fragmentViewTransaction)
            }
            R.id.btnSendMoney -> {
                navigationController.navigate(R.id.action_fragmentMain_to_fragmentChooseRecipient2)
            }
            R.id.btnViewBalance -> {
                navigationController.navigate(R.id.action_fragmentMain_to_fragmentViewBalance)
            }
        }
    }
}