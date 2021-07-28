package com.example.cornetexample.framework.presentation

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ToDoPresenter(var todoView: TodoView?, application: Application) {

    private val repository = com.example.cornetexample.framework.data.NetworkDataSource(application)
    private val scope = CoroutineScope(Dispatchers.IO)
    private val mainScope = CoroutineScope(Dispatchers.Main)

    init {
        scope.launch {
            repository.refreshTodo()
            loadTodoDataFromDB()
        }
    }


    fun loadTodoDataFromDB(){
        todoView?.showProgress()
        mainScope.launch {
            val todoList = repository.getTodos()
            if (todoList.isNotEmpty()) {
                todoView?.hideProgress()
                todoView?.loadTodoData(todoList)
            }
        }
    }



    fun onDestroy() {
        todoView = null
    }

}