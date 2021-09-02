package com.example.readjsondata.repositories

import com.example.readjsondata.Posts
import retrofit2.Call

class PostRepositories {
    val mClient = PostClient().getApi().build.create(PostService::Class.java)

    fun getData(): Call<List<Posts>> {
        return mClient.getPosts()
    }
}