package com.example.core.usecases

import com.example.core.repository.TodoRepository

class GetAllTodo(private val todoRepository: TodoRepository)  {
    suspend operator fun invoke() = todoRepository.getAllTodo()
}