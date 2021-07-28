package com.example.core.repository

import com.example.core.data.Todo

class TodoRepository(private val dataSource: TodoDataSource) {
    suspend fun addTodo(todo: Todo) = dataSource.add(todo)

    suspend fun getTodo(id: Long) = dataSource.get(id)

    suspend fun getAllTodo() = dataSource.getAll()

    suspend fun removeTodo(todo: Todo) = dataSource.remove(todo)
}