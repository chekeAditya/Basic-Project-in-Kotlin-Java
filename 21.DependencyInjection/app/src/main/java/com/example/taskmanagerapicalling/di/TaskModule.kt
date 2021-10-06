package com.example.taskmanagerapicalling.di

import android.content.Context
import androidx.room.Room
import com.example.taskmanagerapicalling.models.local.TaskAppDao
import com.example.taskmanagerapicalling.models.local.TaskRoomDatabase
import com.example.taskmanagerapicalling.models.remote.TasksAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TaskModule {

    @Provides
    fun provideAPIService():TasksAPI{
        val builder = Retrofit.Builder()
            .baseUrl("http://13.232.169.202:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return builder.create(TasksAPI::class.java)
    }

    @Singleton
    @Provides
    fun provideRoomDb(@ApplicationContext context: Context): TaskRoomDatabase {
        val builder = Room.databaseBuilder(
            context, TaskRoomDatabase::class.java, "task_db"
        )
        builder.fallbackToDestructiveMigration()
        return builder.build()
    }

    @Singleton
    @Provides
    fun provideTaskDAO(db: TaskRoomDatabase) :TaskAppDao{
        return db.getTaskDAO()
    }

}