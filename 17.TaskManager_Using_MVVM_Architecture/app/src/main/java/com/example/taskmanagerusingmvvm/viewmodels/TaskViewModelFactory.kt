package com.example.budgetmanager.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.budgetmanager.repository.TaskRepo

class TaskViewModelFactory(val repo: TaskRepo) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TaskViewModel(repo) as T  //typecasting here, T is the generic type here
    }


}