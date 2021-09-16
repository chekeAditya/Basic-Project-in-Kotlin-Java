package com.example.budgetmanager.models

import android.icu.text.CaseMap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "budget_income")
data class BudgetIncome(
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "amount") var amount: Double,
    @ColumnInfo(name = "type") val type: String,
) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null
}

@Entity(tableName = "budget_expense")
data class BudgetExpenses(
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "amount") var amount: Double,
    @ColumnInfo(name = "type") val type: String,
) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null
}