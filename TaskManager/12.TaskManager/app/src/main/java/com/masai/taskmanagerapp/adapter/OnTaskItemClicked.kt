package com.masai.taskmanagerapp.adapter

import com.masai.taskmanagerapp.models.Task

interface OnTaskItemClicked {
    fun onEditClicked(task: Task)
    fun onDeleteClicked(task: Task)
}