package com.example.rough;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ResponseAdapter extends RecyclerView.Adapter<ResponseViewHolder> implements Filterable {

    ArrayList<ResultsItem> data;
    ArrayList<ResultsItem> backUp;

    public ResponseAdapter(ArrayList<ResultsItem> data, ArrayList<ResultsItem> backUp) {
        this.data = data;
        this.backUp = backUp;
    }

    @NonNull
    @Override
    public ResponseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false)
        return new ResponseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResponseViewHolder holder, int position) {
        ResultsItem resultsItem = data.get(position);
        holder.setData(resultsItem);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence keyword) {
            ArrayList<ResultsItem> filteredData = new ArrayList<>();
            if (keyword.toString().isEmpty()) {
                filteredData.addAll(backUp);
            } else {
                for (ResultsItem obj : backUp) {
                    if (obj.getHeader)
                }
            }
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

        }
    }
}
