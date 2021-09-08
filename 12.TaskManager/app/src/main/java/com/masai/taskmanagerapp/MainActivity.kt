package com.masai.taskmanagerapp

import android.annotation.SuppressLint
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.masai.taskmanagerapp.adapter.OnTaskItemClicked
import com.masai.taskmanagerapp.adapter.TasksAdapter
import com.masai.taskmanagerapp.database.DatabaseHandler
import com.masai.taskmanagerapp.models.Task
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnTaskItemClicked {

    lateinit var taskAdapter: TasksAdapter
    private val tasksList = mutableListOf<Task>()
    private val dbHandler = DatabaseHandler(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            dbHandler.insertTask("Complete Recursion", "You had to complete at least 5 question")
            updateUi()
        }
//        Dummy task
//        tasksList.add("task1")
//        tasksList.add("task2")

        tasksList.addAll(dbHandler.getAllTasks())

        taskAdapter = TasksAdapter(this, tasksList, this)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = taskAdapter

    }

    override fun onEditClicked(task: Task) {
        val newTitle = "New Title"
        val newDesc = "New Desc"

        task.title = newTitle
        task.desc = newDesc

        dbHandler.editTask(task)
        updateUi()
    }

    override fun onDeleteClicked(task: Task) {
        dbHandler.deleteTask(task)
        updateUi()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateUi() {
        val latestTask = dbHandler.getAllTasks()
        tasksList.clear() //if we won't do this then it will create a duplicate values
        tasksList.addAll(latestTask)
        taskAdapter.notifyDataSetChanged()
    }
}
