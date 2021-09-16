package com.example.budgetmanager.Ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.budgetmanager.R
import com.example.budgetmanager.databases.BudgetRoomDatabase
import com.example.budgetmanager.interfaces.BudgetDao
import com.example.budgetmanager.models.BudgetExpenses
import com.example.budgetmanager.models.BudgetIncome
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddActivity : AppCompatActivity() {

    lateinit var roomDatabase: BudgetRoomDatabase
    lateinit var budgeDao: BudgetDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        roomDatabase = BudgetRoomDatabase.getDataBaseObject(this)
        budgeDao = roomDatabase.getTaskDao()

        btnincome.setOnClickListener {

            val intent = Intent(this, HomeActivity::class.java)
            var adding = BudgetIncome(tvIncomeDesc.text.toString(), tvIncomeAmount.text.toString().toDouble(),"Income")

            CoroutineScope(Dispatchers.IO).launch {
                budgeDao.addBudgetIncome(adding)
            }
            startActivity(intent)

        }

        btnExpenses.setOnClickListener {

            val intent = Intent(this, HomeActivity::class.java)
            var adding = BudgetExpenses(tvExpensesDesc.text.toString(), tvExpenseAmount.text.toString().toDouble(),"Expenses")

            CoroutineScope(Dispatchers.IO).launch {
                budgeDao.addBudgetExpenses(adding)
            }
            startActivity(intent)

        }
    }
}