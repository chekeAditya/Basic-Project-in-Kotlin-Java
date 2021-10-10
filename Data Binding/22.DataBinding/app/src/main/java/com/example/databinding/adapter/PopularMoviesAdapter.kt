package com.example.databinding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.databinding.R
import com.example.databinding.databinding.ItemLayoutBinding
import com.example.databinding.remote.response.ResultModel

class PopularMoviesAdapter(
    private val popularMoviesModelList: List<ResultModel>
) : RecyclerView.Adapter<PopularMoviesAdapter.PopularMoviesViewHolder>() {


    class PopularMoviesViewHolder(private val itemLayoutBinding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(itemLayoutBinding.root) {

        fun onBind(resultModel: ResultModel) {
            itemLayoutBinding.popularMoviesItem = resultModel

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMoviesViewHolder {
        val itemLayoutBinding:ItemLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.item_layout,parent,false)
        return PopularMoviesViewHolder(itemLayoutBinding)

    }

    override fun onBindViewHolder(holder: PopularMoviesViewHolder, position: Int) {
        val resulModel = popularMoviesModelList[position]
        holder.onBind(resulModel)
    }

    override fun getItemCount(): Int {
        return popularMoviesModelList.size
    }
}