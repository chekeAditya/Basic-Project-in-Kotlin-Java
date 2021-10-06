package com.example.loginsignup.repository

import com.example.loginsignup.network.AuthApi

class AuthRepository(
    private val api: AuthApi
) : BaseRepository() {

    suspend fun login(
        email: String,
        password: String
    ) = safeApiCall { api.login(email, password) }

}