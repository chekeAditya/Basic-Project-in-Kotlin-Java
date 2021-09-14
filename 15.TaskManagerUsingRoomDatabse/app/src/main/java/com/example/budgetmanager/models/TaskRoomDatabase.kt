package com.masai.taskmanagerapp.models

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Task::class], version = 1)
abstract class TaskRoomDatabase : RoomDatabase() {

    abstract fun getTaskDAO(): TaskAppDao

    //creating the object of the room database
    companion object {

        /*
         * creating singleTon(create a single object not creating multiple objects)
         * getDatabaseObject :- this function can be called from many times
         * once we create and store we are not going to create again we will just return it
         */
        private var INSTANCE: TaskRoomDatabase? = null
        fun getDatabaseObject(context: Context): TaskRoomDatabase {
            if (INSTANCE == null) {
                val builder = Room.databaseBuilder(
                    context.applicationContext,
                    TaskRoomDatabase::class.java,
                    "task_db"
                )
                builder.fallbackToDestructiveMigration() //migrate when database changes
                INSTANCE = builder.build()
                return INSTANCE!!
            } else {
                return INSTANCE!!
            }
        }
    }
}