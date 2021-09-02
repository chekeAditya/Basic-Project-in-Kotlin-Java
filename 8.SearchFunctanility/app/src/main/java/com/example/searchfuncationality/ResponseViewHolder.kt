package com.example.searchfuncationality

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.searchfuncationality.Model.DataModel
import kotlinx.android.synthetic.main.item_layout.view.*

class ResponseViewHolder (itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    fun setData(dataModel:DataModel) {
        itemView.apply {
            dataModel.run {
               tvName.text = dataModel.movieName
            }
        }
    }
}