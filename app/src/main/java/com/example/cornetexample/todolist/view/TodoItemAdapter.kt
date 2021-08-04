package com.example.cornetexample.todolist.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cornetexample.R
import com.example.cornetexample.todolist.domain.model.TodoEntity


class TodoItemAdapter(
    private var todoItems: List<TodoEntity>,
): RecyclerView.Adapter<TodoItemAdapter.TodoItemViewHolder>() {

    inner class TodoItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.todo_item,
            parent,
            false
        )
        return TodoItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoItemViewHolder, position: Int) {
        setFadeAnimation(holder.itemView)
        holder.itemView.apply {
            findViewById<TextView>(R.id.todoText).text = todoItems[position].title
            findViewById<TextView>(R.id.todoCompleted).text = todoItems[position].completed.toString()
        }
    }

    override fun getItemCount(): Int {
        return todoItems.size
    }

    private fun setFadeAnimation(view: View) {
        val anim = AlphaAnimation(0.0f, 1.0f)
        anim.duration = 500
        view.startAnimation(anim)
    }
}

