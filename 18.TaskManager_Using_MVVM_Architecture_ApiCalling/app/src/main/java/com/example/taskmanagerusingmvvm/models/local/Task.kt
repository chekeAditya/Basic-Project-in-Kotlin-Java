package com.example.taskmanagerusingmvvm.models.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//now roomdabase understood that it's the database
@Entity(tableName = "tasks")
data class Task(
    @ColumnInfo(name = "title")
    var title: String,
    @ColumnInfo(name = "desc")
    var desc: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null
}
