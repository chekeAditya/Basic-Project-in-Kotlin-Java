package com.example.kotlin

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*

class PostViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {


    //setting textView is done
    fun setData(responseDTOItem: ResponseDTOItem) {
//        view.tvName.text = responseDTOItem.name
//        view.tvBody.text = responseDTOItem.body
//        view.tvEmail.text = responseDTOItem.email
        //instead of the above thing which we wrote we can do it using the scopping function


        //this is called as the scoping function
        view.apply {
            tvName.text = responseDTOItem.name
            tvBody.text = responseDTOItem.body
            tvEmail.text = responseDTOItem.email
        }
    }

}

// There are many scoping function like
// let,run,with,also,apply
