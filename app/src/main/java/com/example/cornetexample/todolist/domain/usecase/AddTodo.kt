package com.example.cornetexample.todolist.domain.usecase

import com.example.cornetexample.todolist.domain.model.TodoEntity
import com.example.cornetexample.todolist.data.TodoListRepository

class AddTodo(private val todoListRepository: TodoListRepository) {
    suspend operator fun invoke(todo: TodoEntity) = todoListRepository.add(todo)
}

