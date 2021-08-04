package com.example.cornetexample.todolist.presenter

import android.app.Application
import android.util.Log
import com.example.cornetexample.NewUseCase
import com.example.cornetexample.todolist.data.TodoListRepository
import com.example.cornetexample.todolist.domain.usecase.AddTodo
import com.example.cornetexample.todolist.domain.usecase.GetAllTodo
import com.example.cornetexample.todolist.view.TodoListView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoListPresenter(private var view: TodoListView?, application: Application) {

    private val repository = TodoListRepository(application)
    private val mainScope = CoroutineScope(Dispatchers.Main)
    private val ioScope = CoroutineScope(Dispatchers.IO)

    init {
        ioScope.launch {
            repository.getAllFromRemote()
            loadDataFromDB()
        }
    }

    private fun loadDataFromDB() {
        mainScope.launch {
            val todoList = repository.localRepository.getAll()
            Log.d("TODO_DATA", "$todoList")
            if (todoList.isNotEmpty()) {
                view?.hideProgress()
                view?.loadTodoData(todoList)
            }
        }
    }

    fun onDestroy() {
        view = null
    }


}