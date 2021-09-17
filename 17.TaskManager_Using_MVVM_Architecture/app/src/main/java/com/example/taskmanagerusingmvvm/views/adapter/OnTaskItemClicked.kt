package com.example.budgetmanager.views.adapter

import com.masai.taskmanagerapp.models.Task


interface OnTaskItemClicked {
    fun onEditClicked(task: Task)
    fun onDeleteClicked(task: Task)
}