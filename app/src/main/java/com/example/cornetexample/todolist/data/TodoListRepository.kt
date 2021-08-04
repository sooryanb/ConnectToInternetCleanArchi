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

    private val newUseCase = NewUseCase(
        AddTodo(this),
        GetAllTodo(this)
    )


    override suspend fun add(item: TodoEntity) = localRepository.add(item)

    override suspend fun get(id: Long): TodoEntity? = localRepository.get(id)

    override suspend fun getAll(): List<TodoEntity> = localRepository.getAll()

    override suspend fun remove(item: TodoEntity) = localRepository.remove(item)

    suspend fun getAllFromRemote() {
        withContext(Dispatchers.IO){
            val todoList = remoteRepository.getAll()
            for(todo in todoList)
                newUseCase.addTodo(todo)
        }
    }

}