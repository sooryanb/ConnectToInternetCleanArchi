package com.example.cornetexample.todolist.domain.usecase

import com.example.cornetexample.todolist.data.TodoListRepository
import com.example.cornetexample.todolist.domain.model.TodoEntity

class UpdateTodo (private val todoListRepository: TodoListRepository) {
   suspend operator fun invoke(todo: TodoEntity) = todoListRepository.updateTodo(todo)
}