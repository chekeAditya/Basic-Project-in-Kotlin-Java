package com.example.coroutine.ViewHolder

import android.view.View
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutine.Model.DataResponse
import kotlinx.android.synthetic.main.item_layout.view.*

class RomanceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun setData(dataResponse: DataResponse) {
        itemView.apply {
            dataResponse.run {
                tvDescription.text = dataResponse.description
                tvLanguage.text = dataResponse.language
                tvMovieName.text = dataResponse.movieName
            }
        }
    }
}