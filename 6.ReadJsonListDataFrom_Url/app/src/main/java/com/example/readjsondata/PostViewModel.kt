package com.example.readjsondata

import androidx.lifecycle.ViewModel
import com.example.readjsondata.repositories.PostRepositories

class PostViewModel:ViewModel() {
    val mPosts = MultableLiveData<List<Posts>>()

    init {
        getData()
    }

    private fun getData(){
        PostRepositories.getData
    }
}