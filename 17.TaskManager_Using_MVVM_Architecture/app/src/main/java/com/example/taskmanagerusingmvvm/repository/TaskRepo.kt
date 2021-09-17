package com.example.budgetmanager.repository

import androidx.lifecycle.LiveData
import androidx.room.Insert
import com.masai.taskmanagerapp.models.Task
import com.masai.taskmanagerapp.models.TaskAppDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * communicate with the database and make the task happens
 * If you need to communicate with the Database then you need to add the object of Dao
 * If you need to communicate with the API-Calling then you need to add the object of Retrofit
 */
class TaskRepo(private val taskAppDao: TaskAppDao) {

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

    fun updateTask(task: Task){
        CoroutineScope(Dispatchers.IO).launch {
            taskAppDao.updateTask(task)
        }
    }


    fun deleteTask(task: Task){
        CoroutineScope(Dispatchers.IO).launch {
            taskAppDao.delete(task)
        }
    }
}