package com.example.cornetexample.framework.data

import android.app.Application
import android.util.Log
import com.example.core.data.Todo
import com.example.core.repository.TodoRepository
import com.example.core.usecases.AddTodo
import com.example.core.usecases.GetAllTodo
import com.example.core.usecases.GetTodo
import com.example.core.usecases.RemoveTodo
import com.example.cornetexample.RoomTodoDataSource
import com.example.cornetexample.UseCase
import com.example.cornetexample.framework.network.Network
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NetworkDataSource(application: Application) {

    private val repository = TodoRepository(RoomTodoDataSource(application))
    private val useCase = UseCase(
        AddTodo(repository),
        GetAllTodo(repository),
        GetTodo(repository),
        RemoveTodo(repository)
    )

    lateinit var currentTodo: List<Todo>

    init {
        GlobalScope.launch {
            currentTodo = getTodos()
        }
    }


    suspend fun getTodos() =
        withContext(Dispatchers.IO){
            val todos: List<Todo> = useCase.getAllTodo()
            todos
        }



    suspend fun refreshTodo(){
        withContext(Dispatchers.IO){
            val todos = Network.getTodoFromRemote()
            Log.d("TODO_FROM_NET", "$todos")
            for (todo in todos){
                useCase.addTodo(todo)
            }
        }
    }


}