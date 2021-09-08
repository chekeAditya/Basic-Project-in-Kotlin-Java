package com.example.updateanddelete

import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.updateanddelete.Database.AdModel

class SomeDataAdapter2(private val ads: List<AdModel>, val listener: OnRowItemClicked) :
    RecyclerView.Adapter<SomeDataAdapter2.SomeDataViewHolder>() {

    class SomeDataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var title: EditText
        lateinit var desc: EditText
        lateinit var price: EditText
        init {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SomeDataViewHolder {

    }

    override fun onBindViewHolder(holder: SomeDataViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
    }
}