package com.example.taskmanagerusingmvvm.views.adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.budgetmanager.repository.TaskRepo
import com.example.budgetmanager.viewmodels.TaskViewModel
import com.example.budgetmanager.viewmodels.TaskViewModelFactory
import com.example.budgetmanager.views.adapter.OnTaskItemClicked
import com.example.budgetmanager.views.adapter.TasksAdapter
import com.example.taskmanagerusingmvvm.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.masai.taskmanagerapp.models.Task
import com.masai.taskmanagerapp.models.TaskAppDao
import com.masai.taskmanagerapp.models.TaskRoomDatabase
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity() : AppCompatActivity(), OnTaskItemClicked {

    lateinit var taskAdapter: TasksAdapter
    private val tasksList = mutableListOf<Task>()


    lateinit var viewModel: TaskViewModel
    lateinit var roomDb: TaskRoomDatabase
    lateinit var taskDao: TaskAppDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        roomDb = TaskRoomDatabase.getDatabaseObject(this)
        taskDao = roomDb.getTaskDAO()

        val repo = TaskRepo(taskDao)
        val viewModelFactory = TaskViewModelFactory(repo)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(TaskViewModel::class.java)

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            val newTask = Task("Dummy Title", "Dummy desc")
            viewModel.addTask(newTask)
        }

        taskAdapter = TasksAdapter(this, tasksList, this)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = taskAdapter

        //subscribing the data which we need
        viewModel.getTasks().observe(this, Observer {
            tasksList.clear()
            tasksList.addAll(it)
            taskAdapter.notifyDataSetChanged()
        })
    }

    override fun onEditClicked(task: Task) {
        val newTitle = "New Title"
        val newDesc = "New Desc"

        task.title = newTitle
        task.desc = newDesc

       viewModel.updateTask(task)
    }

    override fun onDeleteClicked(task: Task) {
        viewModel.deleteTask(task)
    }
}
