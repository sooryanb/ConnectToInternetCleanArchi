package com.example.core.usecases

import com.example.core.data.Todo
import com.example.core.repository.TodoRepository

class RemoveTodo(private val todoRepository: TodoRepository)  {
    suspend operator fun invoke(todo: Todo) = todoRepository.removeTodo(todo)
}