package com.example.coroutine.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coroutine.Adapter.RomanceMovieAdapter
import com.example.coroutine.Model.DataResponse
import com.example.coroutine.Network.ApiClient
import com.example.coroutine.Network.Network
import com.example.coroutine.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import okhttp3.Dispatcher
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {

    private lateinit var job: Job
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    /**
     * Other than Dispatchers.Main we had two more Dispatcher i.e
     * Dispatched.IO -> used for network request or disk read write things
     * Dispatched.Main -> used for main safety
     * Dispatched.Default -> used for CPU intensive tasks
     */

    private val listOfRomanceData: List<DataResponse> = ArrayList<DataResponse>()
    private val romanceMovieAdapter = RomanceMovieAdapter(listOfRomanceData)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Once the our activity or fragment is created we will initialized a job
         */

        job = Job()
        launch {
//            getResponseWithCoroutine() // it will work but we are making network req in the main thread
//            romanceMovieAdapter.data = getResponseWithCoroutine()!!
        }
//        getResponseWithoutCoroutine()
//        getResponseWithCoroutine() //throwing an error we cannot execute it, we can only execute it from coroutine scope


        /**
        GlobalScope.launch(Dispatchers.Main) {
        //  as this is the global scope so the lifecycle is similar to the whole application scope and that's why you should not
        //  here we are making the Network Request in the main thread which we should not do
        //            getResponseWithCoroutine()
        }
         */

        CoroutineScope(Dispatchers.Main).launch {
            romanceMovieAdapter.data = getResponseWithCoroutine()!!
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel() //it will help to cancel whenever it's been destroys and it will cancel the coroutine.
    }

    //    Without Coroutine
    private fun getResponseWithoutCoroutine() {
//        val apiClient = Network.getInstance().create(ApiClient::class.java)
//        apiClient.getRomanticMovies()
//            .enqueue(object : Callback<RomanticMoviesResponse> {
//                override fun onResponse(
//                    call: Call<RomanticMoviesResponse>,
//                    romanceResponse: Response<RomanticMoviesResponse>
//                ) {
//                    romanceResponse.body()?.run {
//                        listOfRomanceData = data
//                        RomanticSetAdapter()
//                    }
//
//                }
//
//                override fun onFailure(call: Call<RomanticMoviesResponse>, t: Throwable) {
//                    Toast.makeText(this@MainActivity, "Failure" + t.message, Toast.LENGTH_LONG).show()
//                }
//
//            })
    }

    /**
     * if we define function as suspend the we can't execute it
     * we can only execute it from a coroutine scope
     * Coroutine is a thread
     */

    private suspend fun getResponseWithCoroutine(): List<DataResponse>? {
        return withContext(Dispatchers.IO) {
            ApiClient().getRomanticMovies().body()?.data
        }
    }


    /**
    private suspend fun getResponseWithCoroutine() {
    val response = ApiClient().getRomanticMovies()
    romanceMovieAdapter.data = response.body()?.data!!
    //        RomanticSetAdapter()
    }
     */


//    fun RomanticSetAdapter() {
//        val romanceMovieAdapter = RomanceMovieAdapter(listOfRomanceData)
//        recyclerView.adapter = romanceMovieAdapter
//        recyclerView.layoutManager = LinearLayoutManager(this)
//    }

}

/**
 * In the API Client make the  fun getRomanticMovies() :Call<RomanticMoviesResponse> as the suspend function like
 *  fun getRomanticMovies() :Call<RomanticMoviesResponse>
 */

/**
 * Global Scope
 * Our approach with coroutine should be we should create a scope which automatically destroyed  it is not needed so it won't cause memory leak
 * But in case of Global Scope it will only destroy when activity destroys so that's why we should not use global scope in production application
 * We should only use this Global scope for quick debugging things.
 * as this is the global scope so the lifecycle is similar to the whole application scope and that's why you should not
 * Here we are making the Network Request in the main thread which we should not do
 */


/**
 * Coroutine Scope
 * WE can also define our own scope i.e coroutine scope
 * For that you can create an interface of Coroutine scope
 */
