package com.example.taskmanagerusingmvvm.views.adapter

import com.example.taskmanagerusingmvvm.models.local.Task


interface OnTaskItemClicked {
    fun onEditClicked(task: Task)
    fun onDeleteClicked(task: Task)
}