package com.example.budgetmanager.interfaces

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.budgetmanager.models.BudgetExpenses
import com.example.budgetmanager.models.BudgetIncome

@Dao
interface BudgetDao {

    //budget_Income
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addBudgetIncome(budgetIncome: BudgetIncome)

    @Query("select * from budget_income")
    fun getAllBudgetIncome():LiveData<List<BudgetIncome>>

    @Query("select SUM(amount) as TOTAL from budget_income")
    fun getAllIncome() : LiveData<Double>

    @Update
    fun updateBudgetIncome(budgetIncome: BudgetIncome)

    @Delete
    fun deleteBudgetIncome(budgetIncome: BudgetIncome)

    //budget_expenses
    @Insert(onConflict = OnConflictStrategy.REPLACE) //Replace the item
    fun addBudgetExpenses(budgetExpenses: BudgetExpenses)

    @Query("select * from budget_expense")
    fun getAllBudgetExpense() : LiveData<List<BudgetExpenses>>

    @Query("select SUM(amount) as TOTAL from budget_expense")
    fun getAllExpenses() : LiveData<Double>

    @Update
    fun updateBudgetExpenses(budgetExpenses: BudgetExpenses)

    @Delete
    fun deleteBudgetExpenses(budgetExpenses: BudgetExpenses)
}