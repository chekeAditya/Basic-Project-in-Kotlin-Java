package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_layout.view.*
import java.util.ArrayList

class SearchViewAdapter(var context: Context, var userDataList: List<DataModel>) :
    RecyclerView.Adapter<SearchViewAdapter.RecyclerviewHolder>() {
    var filteredUserDataList: List<DataModel>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerviewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return RecyclerviewHolder(view)
    }

    //ViewHolder
    override fun onBindViewHolder(holder: RecyclerviewHolder, position: Int) {
        val dataModel: DataModel = userDataList[position]
        holder.setData(dataModel)
    }

    override fun getItemCount(): Int {
        return filteredUserDataList.size
    }

    class RecyclerviewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(dataModel: DataModel) {
            itemView.apply {
                dataModel.run {
                    tvImage.text = dataModel.url
                }
            }
        }

    }

    val filter: Filter
        get() = object : Filter() {
            override fun performFiltering(charSequence: CharSequence): FilterResults {
                val Key = charSequence.toString()
                filteredUserDataList = if (Key.isEmpty()) {
                    userDataList
                } else {
                    val lstFiltered: MutableList<DataModel> = ArrayList()
                    for (row in userDataList) {
                        if (row.url.toLowerCase().contains(Key.toLowerCase())) {
                            lstFiltered.add(row)
                        }
                    }
                    lstFiltered
                }
                val filterResults = FilterResults()
                filterResults.values = filteredUserDataList
                return filterResults
            }

            override fun publishResults(charSequence: CharSequence, filterResults: FilterResults) {
                filteredUserDataList = filterResults.values as List<DataModel>
                notifyDataSetChanged()
            }
        }

    init {
        filteredUserDataList = userDataList
    }
}