package com.example.cornetexample.todolist.data

import android.content.Context
import com.example.cornetexample.NewUseCase
import com.example.cornetexample.core.data.BaseRepository
import com.example.cornetexample.framework.db.AppDatabase
import com.example.cornetexample.framework.network.Network
import com.example.cornetexample.todolist.domain.model.TodoEntity
import com.example.cornetexample.todolist.domain.usecase.AddTodo
import com.example.cornetexample.todolist.domain.usecase.GetAllTodo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TodoListRepository(context: Context): BaseRepository<TodoEntity>() {

    init {
        localRepository = TodoListLocalRepository(AppDatabase.getInstance(context).todoList)
        remoteRepository = TodoListRemoteRepository()
    }


    override suspend fun add(item: TodoEntity) = localRepository.add(item)

    override suspend fun get(id: Long): TodoEntity? = localRepository.get(id)

    override suspend fun getAll(): List<TodoEntity> =
        withContext(Dispatchers.IO){
            val todos = remoteRepository.getAll()
            for (todo in todos)
                localRepository.add(todo)
            localRepository.getAll()
        }

    override suspend fun remove(item: TodoEntity) {
        //val request = remoteRepository.remove(item)
        // if(request)
        localRepository.remove(item)
    }

    suspend fun search(searchString: String) = withContext(Dispatchers.IO){
        val result = (localRepository as TodoListLocalRepository).searchTodoList(searchString)
        result
    }

    suspend fun updateTodo(todo: TodoEntity) = withContext(Dispatchers.IO){
        (localRepository as TodoListLocalRepository).updateTodo(todo)
    }

    suspend fun filterTodoStatus(status: Boolean) = withContext(Dispatchers.IO){
        (localRepository as TodoListLocalRepository).isCompleted(status)
    }

}