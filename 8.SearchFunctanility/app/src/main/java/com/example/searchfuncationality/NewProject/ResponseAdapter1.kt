package com.example.searchfuncationality.NewProject

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import androidx.recyclerview.widget.RecyclerView
import com.example.searchfuncationality.Model.DataModel
import com.example.searchfuncationality.R
import com.example.searchfuncationality.ResponseViewHolder

class ResponseAdapter1(var dataModelList: List<DataModel>) :
    RecyclerView.Adapter<ResponseViewHolder>() {

    var filteredUserDataList: List<DataModel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResponseViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return ResponseViewHolder(view)
    }

    override fun onBindViewHolder(holder: ResponseViewHolder, position: Int) {
        val dataModel: DataModel = filteredUserDataList[position]
        holder.setData(dataModel)
    }

    override fun getItemCount(): Int {
        return filteredUserDataList.size
    }

    val getFilter: Filter
        get() = object : Filter() {
            override fun performFiltering(charSequence: CharSequence): FilterResults {
                val Key = charSequence.toString()
                filteredUserDataList = if (Key.isEmpty()) {
                    dataModelList
                } else {
                    val lstFiltered: MutableList<DataModel> = ArrayList()
                    for (row in dataModelList) {
                        if (row.stringUrl.toLowerCase().contains(Key.toLowerCase())) {
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
        filteredUserDataList = dataModelList
    }
}