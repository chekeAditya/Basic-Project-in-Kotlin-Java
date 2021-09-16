package com.example.budgetmanager.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.budgetmanager.R
import com.example.budgetmanager.interfaces.OnItemClickListener
import com.example.budgetmanager.models.BudgetExpenses
import com.example.budgetmanager.models.BudgetIncome

class BudgetIncomeAdapter(
    private val context: Context,
    val budgetList: MutableList<BudgetIncome>,
    val listener: OnItemClickListener
):RecyclerView.Adapter<BudgetIncomeAdapter.BudgetViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BudgetViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task_layout,parent,false)
        return BudgetViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: BudgetViewHolder, position: Int) {

        val budgetIncome = budgetList[position]
        viewHolder.Description.text = budgetIncome.title
        viewHolder.Amount.text = budgetIncome.amount.toString()

        viewHolder.edittv.setOnClickListener {
            listener.onEditBudgetIncome(budgetIncome)
        }

        viewHolder.deletetv.setOnClickListener {
            listener.onDeleteBudgetIncome(budgetIncome)
        }
    }

    override fun getItemCount(): Int {
        return budgetList.size
    }

    //viewHolder
    class BudgetViewHolder(view: View):RecyclerView.ViewHolder(view) {
        var Description: TextView
        var Amount: TextView
        var edittv: TextView
        var deletetv: TextView

        init {
            Description = view.findViewById(R.id.tvDescription)
            Amount = itemView.findViewById(R.id.tvAmount)
            edittv = itemView.findViewById(R.id.editTv)
            deletetv = itemView.findViewById(R.id.deleteTv)
        }
    }
}

class BudgetExpenseAdapter(
    val context: Context,
    val budgetExpenseList: MutableList<BudgetExpenses>,
    val listener: OnItemClickListener
) :
    RecyclerView.Adapter<TaskHolderexpenses>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskHolderexpenses {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_task_layout, parent, false)
        return TaskHolderexpenses(view)
    }

    override fun onBindViewHolder(holder: TaskHolderexpenses, position: Int) {
        val budgetExpenses = budgetExpenseList[position]
        holder.Description.text = budgetExpenses.title
        holder.Amount.text = budgetExpenses.amount.toString()

        holder.edittv.setOnClickListener {
            listener.onEditBudgetExpense(budgetExpenses)
        }

        holder.deletetv.setOnClickListener {
            listener.onDeleteBudgetExpenses(budgetExpenses)
        }
    }

    override fun getItemCount(): Int {
        return budgetExpenseList.size
    }
}

class TaskHolderexpenses(view: View) : RecyclerView.ViewHolder(view) {
    var Description: TextView
    var Amount: TextView
    var edittv: TextView
    var deletetv: TextView

    init {
        Description = view.findViewById(R.id.tvDescription)
        Amount = itemView.findViewById(R.id.tvAmount)
        edittv = itemView.findViewById(R.id.editTv)
        deletetv = itemView.findViewById(R.id.deleteTv)
    }
}