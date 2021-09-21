package com.example.taskmanagerusingmvvm.views.adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskmanagerusingmvvm.repository.TaskRepo
import com.example.taskmanagerusingmvvm.viewmodels.TaskViewModel
import com.example.taskmanagerusingmvvm.viewmodels.TaskViewModelFactory
import com.example.taskmanagerusingmvvm.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.example.taskmanagerusingmvvm.models.local.Task
import com.example.taskmanagerusingmvvm.models.local.TaskAppDao
import com.example.taskmanagerusingmvvm.models.local.TaskRoomDatabase
import com.example.taskmanagerusingmvvm.models.remote.Status
import com.example.taskmanagerusingmvvm.models.remote.requests.LoginRequestModel
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.longToast


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
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(TaskViewModel::class.java)

        val loginRequestModel = LoginRequestModel(
            userName = "pradeep1706108@gmail.com",
            password = "dhankhar")


        viewModel.userLogin(loginRequestModel).observe(this, Observer {
            val response = it

            //checking the response (success or failure)
            when (response.status) {
                Status.SUCCESS -> {
                    //get the response
                    val name = response.data?.user?.name!!
                    val email = response.data?.user?.email!!
                    longToast("$name and $email")

                }
                Status.ERROR -> {
                    //will show the error
                    val error = response.message!!
                    longToast("$error")
                }
                Status.LOADING -> {
                    //waiting for the response
                    val loading = "Loading"
                    longToast("$loading")
                }
            }
        })

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
