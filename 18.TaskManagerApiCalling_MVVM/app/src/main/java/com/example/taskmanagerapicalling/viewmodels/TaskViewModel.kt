package com.example.taskmanagerapicalling.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.taskmanagerapicalling.repository.TaskRepo
import com.example.taskmanagerapicalling.models.local.Task
import com.example.taskmanagerapicalling.models.remote.Resource
import com.example.taskmanagerapicalling.models.remote.requests.LoginRequestModel
import com.example.taskmanagerapicalling.models.remote.responses.LoginResponse
import kotlinx.coroutines.Dispatchers

class TaskViewModel(val repo: TaskRepo) : ViewModel() {

    fun userLogin(loginRequestModel: LoginRequestModel): LiveData<Resource<LoginResponse>> {
        val livedata =  liveData(Dispatchers.IO){
            val result = repo.login(loginRequestModel)
            emit(result)
        }
        return livedata
      /**
        CoroutineScope(Dispatchers.IO).launch {
            repo.login(loginRequestModel)
        }
        */
    }

    fun addTask(task: Task) {
        repo.addTaskToRoom(task)
    }

    fun getTasks(): LiveData<List<Task>> {
        return repo.getAllTask()
    }

    fun updateTask(task: Task) {
        repo.updateTask(task)
    }

    fun deleteTask(task: Task) {
        repo.deleteTask(task)
    }

}