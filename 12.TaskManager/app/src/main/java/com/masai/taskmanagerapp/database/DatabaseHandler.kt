package com.masai.taskmanagerapp.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.masai.taskmanagerapp.models.Task

class DatabaseHandler(private val context: Context) :
    SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    companion object {
        val DB_NAME = "taskDB"
        val DB_VERSION = 1
        val TABLE_NAME = "tasks"
        val ID = "id"
        val TITLE = "title"
        val DESC = "desc"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        /**
         * Called only once, if you had to modify, init or creation related things goes here
         */

        //table created
        val CREATE_TABLE_QUERY = "CREATE TABLE " +
                "$TABLE_NAME(" +
                "$ID INTEGER PRIMARY KEY," +
                "$TITLE TEXT, " +
                "$DESC TEXT)"

        db?.execSQL(CREATE_TABLE_QUERY)
    }


    fun insertTask(title: String, desc: String) {
//        val db = readableDatabase //if you just need to read not to modify then use this
        val db = writableDatabase
        val values = ContentValues()
        values.put(TITLE, title)
        values.put(DESC, desc)

        val idValue = db.insert(
            TABLE_NAME,
            null,
            values
        ) //using this we are inserting the data into the table
        if (idValue.toInt() == -1) { //idValue is a long value
            Toast.makeText(context, "Failed to insert Data", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Successfully inserted the row", Toast.LENGTH_SHORT).show()
        }
    }

    fun getAllTasks(): MutableList<Task> {
        val taskList = mutableListOf<Task>()
        val db = readableDatabase
        val query = "select * from $TABLE_NAME"
        //it will execute and return all the value which it had
        val cursor = db.rawQuery(query, null)
        if (cursor != null && cursor.count > 0) {
            cursor.moveToFirst()

            do {
                //got the data
                val id = cursor.getInt(cursor.getColumnIndex(ID))
                val title = cursor.getString(cursor.getColumnIndex(TITLE))
                val desc = cursor.getString(cursor.getColumnIndex(DESC))

                val task = Task()
                task.id = id
                task.title = title
                task.desc = desc

                taskList.add(task)

            } while (cursor.moveToNext())

        }
        return taskList
    }

    /**
     * we should have the task id to change it
     *
     */
    fun editTask(task: Task) {
        val db = writableDatabase
        val contentValues = ContentValues()
        contentValues.put(TITLE, task.title)
        contentValues.put(DESC, task.desc)
        //update tasks where id = task.id
        val result = db.update(TABLE_NAME, contentValues, "id=${task.id}", null)
        if (result == 1) {
            Toast.makeText(context, "Task Updated Successfully", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Task Updating failed", Toast.LENGTH_SHORT).show()
        }
    }


    fun deleteTask(task: Task) {
        val db = writableDatabase
        val result = db.delete(TABLE_NAME, "id=${task.id}", null)
        if (result == 1) {
            Toast.makeText(context, "Task Deleted Successfully", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Task Failed To  Delete", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        /**
         * Everytime we release the app we had to change the version
         * Whatever change we had made we had to write it here
         */
    }
}
