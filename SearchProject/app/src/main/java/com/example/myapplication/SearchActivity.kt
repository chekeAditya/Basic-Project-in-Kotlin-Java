package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_search.*
import java.util.ArrayList

class SearchActivity : AppCompatActivity() {
    var userRecycler: RecyclerView? = null
    var recyclerviewAdapter: SearchViewAdapter? = null
    var searchView: EditText? = null
    var search: CharSequence = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        searchView = findViewById(R.id.etSearchData)
        val userDataList: MutableList<DataModel> = ArrayList()
        userDataList.add(DataModel("Rudra Boom Chik Chik Boom","https://images-na.ssl-images-amazon.com/images/S/pv-target-images/96892ad98f9bc6a6b7564692d78790428fdedb669c08f30d1b1f817876d8da08._RI_V_TTW_.jpg"))
        userDataList.add(DataModel("Aditya Cheke"))
        userDataList.add(DataModel("Sudarshan Parsad"))
        userDataList.add(DataModel("Mausam Singh"))
        userDataList.add(DataModel("Prabhakar Kumar"))
        userDataList.add(DataModel("Niket Nayan"))
        userDataList.add(DataModel("Adams Green"))
        setUserRecycler(userDataList)
        etSearchData.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                recyclerviewAdapter?.filter?.filter(charSequence)
                search = charSequence
            }

            override fun afterTextChanged(editable: Editable) {}
        })
    }

    private fun setUserRecycler(userDataList: List<DataModel>) {
        val layoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.setLayoutManager(layoutManager)
        recyclerviewAdapter = SearchViewAdapter(this, userDataList)
        recyclerView.setAdapter(recyclerviewAdapter)
    }
}