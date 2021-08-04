package com.example.cornetexample.todolist.view

import com.example.cornetexample.todolist.domain.model.TodoEntity

interface TodoListView {
    fun showProgress()
    fun hideProgress()
    fun loadTodoData(todos: List<TodoEntity>)
}