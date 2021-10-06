package com.example.loginsignup.repository

import com.example.loginsignup.network.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

abstract class BaseRepository {
    //here T is the actual response we should get
    suspend fun <T> safeApiCall(
        apicall: suspend () -> T
    ): Resource<T> {
        return withContext(Dispatchers.IO) {
            try {
                Resource.Success(apicall.invoke())
            } catch (throwable: Throwable) {
                when(throwable){
                    is HttpException -> {
                        Resource.Failure(false,throwable.code(),throwable.response()?.errorBody())
                    }
                    else -> {
                        Resource.Failure(true,null,null)
                    }
                }
            }
        }
    }
}