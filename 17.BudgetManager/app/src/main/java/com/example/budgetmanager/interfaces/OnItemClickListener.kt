package com.example.budgetmanager.interfaces

import com.example.budgetmanager.models.BudgetExpenses
import com.example.budgetmanager.models.BudgetIncome

interface OnItemClickListener {

    fun onEditBudgetIncome(budgetIncome: BudgetIncome)
    fun onDeleteBudgetIncome(budgetIncome: BudgetIncome)

    fun onEditBudgetExpense(budgetExpenses: BudgetExpenses)
    fun onDeleteBudgetExpenses(budgetExpenses: BudgetExpenses)

}