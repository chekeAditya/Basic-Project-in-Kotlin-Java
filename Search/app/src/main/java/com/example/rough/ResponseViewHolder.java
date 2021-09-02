package com.example.rough;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class ResponseViewHolder extends RecyclerView.ViewHolder {

    ImageView mImageView;

    public ResponseViewHolder(@NonNull View itemView) {
        super(itemView);
        mImageView = itemView.findViewById(R.id.ivImage);
    }

    public void setData(ResultsItem resultsItem) {
        Glide.with(mImageView).load("https://image.tmdb.org/t/p/w500/" + resultsItem.getPosterPath()).into(mImageView);
    }
}
