package com.example.core.usecases

import com.example.core.repository.TodoRepository

class GetTodo(private val todoRepository: TodoRepository)  {
    suspend operator fun invoke(id: Long) = todoRepository.getTodo(id)
}