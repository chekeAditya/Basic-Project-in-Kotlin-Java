package com.example.budgetmanager.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.budgetmanager.repository.TaskRepo
import com.masai.taskmanagerapp.models.Task

class TaskViewModel(val repo: TaskRepo):ViewModel() {

    fun addTask(task: Task){
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