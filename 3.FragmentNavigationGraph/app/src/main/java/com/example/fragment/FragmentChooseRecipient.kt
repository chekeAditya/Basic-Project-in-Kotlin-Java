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

class FragmentChooseRecipient : Fragment(R.layout.fragment_choose_recipient), View.OnClickListener {

    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        navController = Navigation.findNavController(view)
    }

    private fun initListeners() {
        btnNext.setOnClickListener(this)
        btnCanCel.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnNext -> {
                val bundle = Bundle()
                bundle.putString("recipentName", etName.text.toString())
                navController.navigate(R.id.action_fragmentChooseRecipient_to_fragmentSpecificAmount2,bundle)
            }
            R.id.btnCanCel -> {
                activity?.onBackPressed()
            }
        }
    }
}