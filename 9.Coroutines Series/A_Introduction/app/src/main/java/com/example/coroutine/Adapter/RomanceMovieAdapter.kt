package com.example.coroutine.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutine.Model.DataResponse
import com.example.coroutine.R
import com.example.coroutine.ViewHolder.RomanceViewHolder

class RomanceMovieAdapter(var data: List<DataResponse>) :
    RecyclerView.Adapter<RomanceViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RomanceViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return RomanceViewHolder(view)
    }

    override fun onBindViewHolder(holder: RomanceViewHolder, position: Int) {
        val datalist: DataResponse = data[position]
        holder.setData(datalist)
    }

    override fun getItemCount(): Int {
        return data.size
    }

}