package com.example.cornetexample.todolist.domain.usecase

import com.example.cornetexample.todolist.data.TodoListRepository
import com.example.cornetexample.todolist.domain.model.TodoEntity

class DeleteTodo (private val todoListRepository: TodoListRepository) {
    suspend operator fun invoke(todo: TodoEntity) = todoListRepository.remove(todo)
}
