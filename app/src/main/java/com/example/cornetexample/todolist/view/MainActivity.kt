package com.example.cornetexample.todolist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import androidx.core.view.isGone
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cornetexample.R
import com.example.cornetexample.todolist.domain.model.TodoEntity
import com.example.cornetexample.todolist.presenter.TodoListPresenter

class MainActivity : AppCompatActivity(), TodoListView {

    private lateinit var presenter: TodoListPresenter

    private lateinit var progressBar: ProgressBar
    private lateinit var todoRecyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = TodoListPresenter(this, application)
        progressBar = findViewById(R.id.loadingView)
        todoRecyclerView = findViewById(R.id.recyclerView)
    }

    override fun showProgress() {
        progressBar = findViewById(R.id.loadingView)
        progressBar.isGone = false
    }

    override fun hideProgress() {
        progressBar = findViewById(R.id.loadingView)
        progressBar.isGone = true
    }

    override fun loadTodoData(todoList: List<TodoEntity>) {
        todoRecyclerView = findViewById(R.id.recyclerView)
        val adapter = TodoItemAdapter(todoList)
        todoRecyclerView.adapter = adapter
        todoRecyclerView.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
    }


    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }


}