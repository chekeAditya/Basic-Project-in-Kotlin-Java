package com.example.searchfuncationality

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.searchfuncationality.Model.DataModel
import com.example.searchfuncationality.Model.ResponseModel
import com.example.searchfuncationality.NetworkClass.ApiClient
import com.example.searchfuncationality.NetworkClass.Network
import kotlinx.android.synthetic.main.activity_search.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchActivity : AppCompatActivity() {


    var userRecycler: RecyclerView? = null
    var recyclerviewAdapter1: ResponeAdapter? = null
    var searchView: EditText? = null
    var search: CharSequence = ""
    private lateinit var dataModelList: List<DataModel>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
//        InidanToons()

        userDataList.add(DataModel("Nishant Rishab"))
        userDataList.add(DataModel("Aditya Cheke"))
        userDataList.add(DataModel("Sudarshan Parsad"))
        userDataList.add(DataModel("Mausam Singh"))
        userDataList.add(DataModel("Prabhakar Kumar"))
        userDataList.add(DataModel("Niket Nayan"))
        userDataList.add(DataModel("Adams Green"))

        etSearchData.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                recyclerviewAdapter1?.getFilter?.filter(charSequence)
                search = charSequence
            }

            override fun afterTextChanged(editable: Editable) {}
        })
    }

    private fun InidanToons() {
        val apiClient4 = Network.getInstance().create(ApiClient::class.java)
        apiClient4.getIndianToons().enqueue(
            object : Callback<ResponseModel> {
                override fun onResponse(
                    call: Call<ResponseModel>,
                    response: Response<ResponseModel>,
                ) {
                    response.body()?.run {
                        dataModelList = dataModels
                        setInidanToonsRecycler()
                    }
                }

                override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                }
            }
        )
    }

    private fun setInidanToonsRecycler() {
        val linearLayoutManager =
            LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        val indianToon = ResponeAdapter(dataModelList)
        recyclerView.adapter = indianToon
        recyclerView.layoutManager = linearLayoutManager
    }
}