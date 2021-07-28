package com.example.cornetexample.framework.presentation

import com.example.core.data.Todo

interface TodoView {
    fun showProgress()
    fun hideProgress()
    fun loadTodoData(todos: List<Todo>)
}