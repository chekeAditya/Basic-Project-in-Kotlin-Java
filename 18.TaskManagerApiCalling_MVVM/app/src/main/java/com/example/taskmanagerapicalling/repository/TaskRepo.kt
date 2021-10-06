package com.example.taskmanagerapicalling.repository

import androidx.lifecycle.LiveData
import com.example.taskmanagerapicalling.models.local.Task
import com.example.taskmanagerapicalling.models.local.TaskAppDao
import com.example.taskmanagerapicalling.models.remote.Network
import com.example.taskmanagerapicalling.models.remote.Resource
import com.example.taskmanagerapicalling.models.remote.ResponseHandler
import com.example.taskmanagerapicalling.models.remote.TasksAPI
import com.example.taskmanagerapicalling.models.remote.requests.LoginRequestModel
import com.example.taskmanagerapicalling.models.remote.responses.LoginResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * communicate with the database and make the task happens
 * If you need to communicate with the Database then you need to add the object of Dao
 * If you need to communicate with the API-Calling then you need to add the object of Retrofit
 */
class TaskRepo(private val taskAppDao: TaskAppDao) {

    private val api: TasksAPI = Network.getRetrofit().create(TasksAPI::class.java)
    private val responseHandler = ResponseHandler()

    //as it will take some time so that's we are marking it as suspend function
    suspend fun login(loginRequestModel: LoginRequestModel): Resource<LoginResponse> {
        return try {
            val response = api.login(loginRequestModel)
            responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            e.printStackTrace()
            responseHandler.handleException(e) //passing exception here
        }
    }

    // this operation should be happened in the bg thread
    fun addTaskToRoom(task: Task) {
        CoroutineScope(Dispatchers.IO).launch {
            taskAppDao.addTask(task)    
        }
    }


    //returning the live data of list
    fun getAllTask(): LiveData<List<Task>> {
        return taskAppDao.getTasks()
    }

    fun updateTask(task: Task) {
        CoroutineScope(Dispatchers.IO).launch {
            taskAppDao.updateTask(task)
        }
    }


    fun deleteTask(task: Task) {
        CoroutineScope(Dispatchers.IO).launch {
            taskAppDao.delete(task)
        }
    }
}