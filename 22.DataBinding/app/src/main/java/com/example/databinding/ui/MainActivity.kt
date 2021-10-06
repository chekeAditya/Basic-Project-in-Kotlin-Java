package com.example.databinding.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.databinding.R
import com.example.databinding.adapter.PopularMoviesAdapter
import com.example.databinding.databinding.ActivityMainBinding
import com.example.databinding.remote.response.ResultModel
import com.example.databinding.viewmodel.ViewModelMovies
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var viewModelMovies: ViewModelMovies
    lateinit var activityMainBinding: ActivityMainBinding
    lateinit var popularMoviesAdapter: PopularMoviesAdapter
    var resultList = mutableListOf<ResultModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModelMovies = ViewModelProviders.of(this).get(ViewModelMovies::class.java)

        activityMainBinding.apply {
            popularMoviesAdapter = PopularMoviesAdapter(resultList)
            rvPopularMovies.layoutManager = LinearLayoutManager(this@MainActivity)
            rvPopularMovies.adapter = popularMoviesAdapter
        }

        viewModelMovies.getDataFromAPI().observe(this, Observer {
            resultList.clear()
            resultList.addAll(it)
            popularMoviesAdapter.notifyDataSetChanged()
        })
        viewModelMovies.getDataFromAPI()
    }
}
