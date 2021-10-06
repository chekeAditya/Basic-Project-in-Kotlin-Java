package com.example.taskmanagerapicalling.views.adapter

import com.example.taskmanagerapicalling.models.local.Task


interface OnTaskItemClicked {
    fun onEditClicked(task: Task)
    fun onDeleteClicked(task: Task)
}