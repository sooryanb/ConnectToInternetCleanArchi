package com.example.core.usecases

import com.example.core.data.Todo
import com.example.core.repository.TodoRepository

class AddTodo(private val todoRepository: TodoRepository) {
    suspend operator fun invoke(todo: Todo) = todoRepository.addTodo(todo)
}