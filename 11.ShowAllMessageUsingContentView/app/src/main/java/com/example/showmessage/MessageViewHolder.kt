package com.example.showmessage

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*

class MessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {


    fun setData(messageDTO: MessageDTO) {
        itemView.apply {
            messageDTO.run {
                tvHeading.text = messageDTO.heading
                tvDescription.text = messageDTO.description
            }
        }
    }
}
/*
if(list[position].image != null)
            holder.profile.setImageBitmap(list[position].image)
        else
            holder.profile.setImageDrawable(ContextCompat.getDrawable(context,R.mipmap.ic_launcher_round))
 */