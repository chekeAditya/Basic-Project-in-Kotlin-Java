package com.example.taskmanagerapicalling.adapter

import com.example.taskmanagerapicalling.models.local.Task


interface OnTaskItemClicked {
    fun onEditClicked(task: Task)
    fun onDeleteClicked(task: Task)
}