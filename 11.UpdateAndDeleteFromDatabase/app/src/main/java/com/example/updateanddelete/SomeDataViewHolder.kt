package com.example.updateanddelete

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.updateanddelete.Database.AdModel

class SomeDataViewHolder(itemView: View):RecyclerView.ViewHolder() {

    fun setData(adModel: AdModel){
        itemView.apply {
            adModel.run {

            }
        }
    }
}