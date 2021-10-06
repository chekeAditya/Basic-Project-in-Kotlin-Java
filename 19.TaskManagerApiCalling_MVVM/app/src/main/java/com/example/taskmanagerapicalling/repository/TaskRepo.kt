package com.example.taskmanagerapicalling.repository

import androidx.lifecycle.LiveData
import com.example.taskmanagerapicalling.models.local.Task
import com.example.taskmanagerapicalling.models.local.TaskAppDao
import com.example.taskmanagerapicalling.models.remote.Network
import com.example.taskmanagerapicalling.models.remote.Resource
import com.example.taskmanagerapicalling.models.remote.ResponseHandler
import com.example.taskmanagerapicalling.models.remote.TasksAPI
import com.example.taskmanagerapicalling.models.remote.requests.LoginRequestModel
import com.example.taskmanagerapicalling.models.remote.responses.getTasksResponse.GetTasksResponseModel
import com.example.taskmanagerapicalling.models.remote.responses.login.LoginResponse
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
    private val token =
        "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MGE0YmI3OTAzMjdlN2MwNmE2MTk1ODYiLCJpYXQiOjE2MzIxMzg2ODR9.cTxpYQrTfvramIOSPih6b1hJO_x1G-V2GmaRnTYSjU0"

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

    fun getRemoteTasks() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = api.getTaskFromAPI(token)
            saveToDB(response)
        }
    }

    //once we get the response using this function will save it to Local Database
    private fun saveToDB(response: GetTasksResponseModel) {
        val listOfTasks = ArrayList<Task>()
        response.forEach {
            val newTask = Task(it.title,it.description)
//            taskAppDao.addTask(newTask) //this will add only one Task
            listOfTasks.add(newTask)
        }
        taskAppDao.deleteAllData()
        taskAppDao.addTasks(listOfTasks) //this will add all the tasks
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