package com.masai.taskmanagerapp.models

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TaskAppDao {

    //insertData into table
    @Insert(onConflict = OnConflictStrategy.REPLACE) //used when you insert the same data
    fun addTask(task: Task)

    //getting the data
    @Query("select * from tasks") //we can use single data using select id,title,`desc` from tasks
    fun getTasks(): LiveData<List<Task>> //returning the list of tasks or if we wrap with LiveData then it will give the live data

    //updating data to update it uses the primary key
    @Update
    fun updateTask(task: Task)

    //Delete
    @Delete
    fun delete(task: Task)

}
/**
 * Insert is an operation and what to insert :- insert Task
 */