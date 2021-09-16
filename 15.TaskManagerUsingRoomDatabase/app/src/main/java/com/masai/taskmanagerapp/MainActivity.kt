package com.masai.taskmanagerapp

import android.annotation.SuppressLint
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.masai.taskmanagerapp.adapter.OnTaskItemClicked
import com.masai.taskmanagerapp.adapter.TasksAdapter
import com.masai.taskmanagerapp.models.Task
import com.masai.taskmanagerapp.models.TaskAppDao
import com.masai.taskmanagerapp.models.TaskRoomDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), OnTaskItemClicked {

    lateinit var taskAdapter: TasksAdapter
    private val tasksList = mutableListOf<Task>()

    lateinit var roomDb: TaskRoomDatabase
    lateinit var taskDao: TaskAppDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        roomDb = TaskRoomDatabase.getDatabaseObject(this)
        taskDao = roomDb.getTaskDAO()

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            val newTask = Task("Dummy Title", "Dummy desc")

            CoroutineScope(Dispatchers.IO).launch {
                //launch don't different anything but run return somethings
                taskDao.addTask(newTask)
            }
        }

        taskAdapter = TasksAdapter(this, tasksList, this)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = taskAdapter

            taskDao.getTasks("hello").observe(this@MainActivity, Observer {
                val tasks = it
                tasksList.clear()
                tasksList.addAll(tasks)
                taskAdapter.notifyDataSetChanged()
            })
    }

    override fun onEditClicked(task: Task) {
        val newTitle = "New Title"
        val newDesc = "New Desc"

        task.title = newTitle
        task.desc = newDesc

        updateUi()
    }

    override fun onDeleteClicked(task: Task) {

    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateUi() {
        tasksList.clear() //if we won't do this then it will create a duplicate values
        taskAdapter.notifyDataSetChanged()
    }
}
/**
 * room bydefault will not permit you do any operation on Ui thread
 */