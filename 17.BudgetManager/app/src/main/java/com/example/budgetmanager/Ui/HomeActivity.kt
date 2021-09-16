package com.example.budgetmanager.Ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.budgetmanager.R
import com.example.budgetmanager.adapters.BudgetExpenseAdapter
import com.example.budgetmanager.adapters.BudgetIncomeAdapter
import com.example.budgetmanager.databases.BudgetRoomDatabase
import com.example.budgetmanager.interfaces.BudgetDao
import com.example.budgetmanager.interfaces.OnItemClickListener
import com.example.budgetmanager.models.BudgetExpenses
import com.example.budgetmanager.models.BudgetIncome
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity(), OnItemClickListener {

    private var budgetListIncome = mutableListOf<BudgetIncome>()
    private var budgetListExpenses = mutableListOf<BudgetExpenses>()
    private lateinit var budgetIncomeAdapter: BudgetIncomeAdapter
    private lateinit var budgetExpensesAdapter: BudgetExpenseAdapter
    private lateinit var roomDatabase: BudgetRoomDatabase
    private lateinit var budgetDao: BudgetDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        roomDatabase = BudgetRoomDatabase.getDataBaseObject(this)
        budgetDao = roomDatabase.getTaskDao()

        fab.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }


        //income setting adaptor
        budgetIncomeAdapter = BudgetIncomeAdapter(this, budgetListIncome, this)
        recyclerViewIncome.adapter = budgetIncomeAdapter
        recyclerViewIncome.layoutManager = LinearLayoutManager(this)

        //expenses setting adaptor
        budgetExpensesAdapter = BudgetExpenseAdapter(this, budgetListExpenses, this)
        recyclerViewExpense.adapter = budgetExpensesAdapter
        recyclerViewExpense.layoutManager = LinearLayoutManager(this)


        var income = 0.0
        var expense = 0.0

        //to add income
        budgetDao.getAllIncome().observe(this, Observer {
            if (it != null) {
                tvIncome.text = it.toString()
                income = it
                tvBalance.text = (income - expense).toString()

            } else {
                tvIncome.text = "0.0"
            }
        })

        // to add Expense
        budgetDao.getAllExpenses().observe(this, Observer {
            if (it != null) {
                tvExpense.text = it.toString()
                expense = it
                tvBalance.text = (income - expense).toString()
            } else {
                tvExpense.text = "0.0"
            }
        })

        if (income == null && expense == null) {
            tvBalance.text = "0.0"
        }

        //to live data
        budgetDao.getAllBudgetIncome().observe(this, Observer {
            val task = it
            CoroutineScope(Dispatchers.IO).launch {
                budgetListIncome.clear()
                budgetListIncome.addAll(task)
                budgetIncomeAdapter.notifyDataSetChanged()

            }
        })

        budgetDao.getAllBudgetExpense().observe(this, Observer {
            val task = it

            CoroutineScope(Dispatchers.IO).launch {
                budgetListExpenses.clear()
                budgetListExpenses.addAll(task)
                budgetExpensesAdapter.notifyDataSetChanged()

            }
        })
    }


    override fun onEditBudgetIncome(budgetIncome: BudgetIncome) {
        linearLinear.visibility = View.VISIBLE
        btnUpdate.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                budgetIncome.title = eteditdesc.text.toString()
                budgetIncome.amount = eteditamount.text.toString().toDouble()
                budgetDao.updateBudgetIncome(budgetIncome)
            }
            linearupdate.visibility = View.GONE
        }
    }

    override fun onDeleteBudgetIncome(budgetIncome: BudgetIncome) {
        CoroutineScope(Dispatchers.IO).launch {
            budgetDao.deleteBudgetIncome(budgetIncome)
        }
    }


    override fun onEditBudgetExpense(budgetExpenses: BudgetExpenses) {
        linearupdate.visibility = View.VISIBLE
        btnUpdate.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                budgetExpenses.title = eteditdesc.text.toString()
                budgetExpenses.amount = eteditamount.text.toString().toDouble()
                budgetDao.updateBudgetExpenses(budgetExpenses)
            }
            linearupdate.visibility = View.GONE
        }
    }

    override fun onDeleteBudgetExpenses(budgetExpenses: BudgetExpenses) {
        CoroutineScope(Dispatchers.IO).launch {
            budgetDao.deleteBudgetExpenses(budgetExpenses)
        }
    }
}