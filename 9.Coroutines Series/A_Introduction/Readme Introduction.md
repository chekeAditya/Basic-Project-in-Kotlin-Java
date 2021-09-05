## What is coroutine?
-> A coroutine is a concurrency design pattern that you can use on Android to simplify code that executes asynchronously.
-> Concurrency :- concurrency is the ability of different parts or units of a program, algorithm, or problem to be executed out-of-order or at the same time simultaneously partial order, without affecting the final outcome.
               :-  the execution of a set of multiple instruction sequences at the same time
-> Asynchronous :- controlling the timing of operations by the use of pulses sent when the previous operation is completed rather than at regular intervals


## The Problem with Asynchronous Codes ?
-> fun fetchDataFromNetwork(){
        val result = networkRequest()  //blocks Main Thread
        updateUI(result)
    }
-> this function fetch data from Internet and Show it in the main function.
-> As code is synchronously written in the main thread it blocks the Ui. and Android don't allow to write in Main thread.

## The Solution
-> class MyAsyncTask() : AsyncTask<Void,Void,String>(){
        override fun doInBackground(vararg parms : Void?):String? {
            return networkRequest()
        }
        override fun onPostExecute(result : String?) {
            super.onnPostExecute(result)
            updateUi(result)
        }
    }
-> Here you can see we had two function doInBackground and onPostExecute inside we perform networkRequest and onPostExecute we perform Ui opereation

## or if you are using Retrofit
-> call.enqueue(object:Callback<MyResult>{
        override fun onResponse(call: Call<MyResult), response:Response: Response<MyResult>){
            //process response
        }
        override fun onFailure(call: Call<MyResult), response: t: Throwable){
            //handle failure
        }
    })

## Problem with Callbacks
-> call1.enqueue(object:Callback<MyResult>{
        override fun onResonse(call: Call<MyResult>, reponse: Response<MyResult>){
            call2.enqueue(object:Callback<MyResult>){
                override fun onResponse(call: Call<MyResult>,response: Response<MyResult>){
                    call3.enqueue(object:Callback<MyResult>){
                        override fun onResponse(call: Call<MyResult>,response: Response<MyResult>){
                            //code
                        }
                         override fun onResponse(call: Call<MyResult>,response: Response<MyResult>){
                            //handler failure
                        }    
                })
            }
        }
        override fun onResponse(call: Call<MyResult>,response: Response<MyResult>){
            //handler failure
        }  
    })
-> here we had only 3 callback and code is so ugly that's why we used Coroutines.

## Solution with Coroutines
-> suspend fun fetchDataFromNetwork(){
        val result = networkRequest()
        updateUi(result) //this is the callback
    }
-> ALl code is same as in the Asynchronous code the only change is here we are using Suspend keyword before the function
-> Suspend basically means this function needs a coroutine before it get executes
-> we can't call suspend function directly we need a coroutine to call a suspend function.
-> Here you can consider coroutine as a separate thread.
-> suspend means function can suspend and start. It means writing callback in a simpler and cleaner way.
-> Here networkRequest() will be called Asynchronously in the IO thread and we get the result and process it in Main Thread.
-> Here updateUi is our callback
-> it synchronous but it is actually Asynchronous


