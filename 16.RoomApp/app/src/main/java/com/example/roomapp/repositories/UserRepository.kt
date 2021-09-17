package com.example.roomapp.repositories

import androidx.lifecycle.LiveData
import com.example.roomapp.model.User
import com.example.roomdatabase.data.UserDao

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }
}