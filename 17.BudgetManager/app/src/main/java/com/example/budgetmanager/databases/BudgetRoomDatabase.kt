package com.example.budgetmanager.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.budgetmanager.interfaces.BudgetDao
import com.example.budgetmanager.models.BudgetExpenses
import com.example.budgetmanager.models.BudgetIncome

@Database(entities = [BudgetIncome::class, BudgetExpenses::class], version = 2)
abstract class BudgetRoomDatabase : RoomDatabase() {

    abstract fun getTaskDao(): BudgetDao

    companion object {
        private var INSTANCE: BudgetRoomDatabase? = null

        fun getDataBaseObject(context: Context): BudgetRoomDatabase {
            if (INSTANCE == null) {

                val builder = Room.databaseBuilder(
                    context.applicationContext,
                    BudgetRoomDatabase::class.java,
                    "task_db"
                )
                builder.fallbackToDestructiveMigration()

                INSTANCE = builder.build()
                return INSTANCE!!
            } else {
                return INSTANCE!!
            }
        }
    }
}
