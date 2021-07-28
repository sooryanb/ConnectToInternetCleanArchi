package com.example.core.repository

import com.example.core.data.Todo

interface TodoDataSource {
    suspend fun add(todo: Todo)

    suspend fun get(id: Long): Todo?

    suspend fun getAll(): List<Todo>

    suspend fun remove(todo: Todo)
}