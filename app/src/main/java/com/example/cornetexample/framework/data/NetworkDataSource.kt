package com.example.cornetexample.framework.data

import android.app.Application
import android.util.Log
import com.example.cornetexample.NewUseCase
import com.example.cornetexample.framework.network.Network
import com.example.cornetexample.todolist.data.TodoListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NetworkDataSource(application: Application) {


    private val todoListRepository = TodoListRepository(application)
    private val newUseCase = NewUseCase(
        com.example.cornetexample.todolist.domain.usecase.AddTodo(todoListRepository),
        com.example.cornetexample.todolist.domain.usecase.GetAllTodo(todoListRepository)
    )



//    lateinit var currentTodo: List<Todo>

//    init {
//        GlobalScope.launch {
//            currentTodo = getTodos()
//        }
//    }


//    suspend fun getTodos() =
//        withContext(Dispatchers.IO){
//            val todos: List<Todo> = useCase.getAllTodo()
//            todos
//        }

    suspend fun getLatestTodo(){
        withContext(Dispatchers.IO){
            val todoList = Network.getTodoFromRemote()
            for(todo in todoList)
                newUseCase.addTodo(todo)
        }
    }


//    suspend fun refreshTodo(){
//        withContext(Dispatchers.IO){
//            val todos = Network.getTodoFromRemoteV1()
//            Log.d("TODO_FROM_NET", "$todos")
//            for (todo in todos){
//                useCase.addTodo(todo)
//            }
//        }
//    }


}