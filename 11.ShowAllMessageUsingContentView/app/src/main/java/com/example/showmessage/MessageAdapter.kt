package com.example.showmessage

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MessageAdapter(items: List<MessageDTO>) :
    RecyclerView.Adapter<MessageViewHolder>() {

    private var list = items

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val messageDTO: MessageDTO = list[position]
        holder.setData(messageDTO)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}
