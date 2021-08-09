package com.example.cornetexample.todolist.domain.usecase

import com.example.cornetexample.todolist.data.TodoListRepository

class StatusFilter (private val todoListRepository: TodoListRepository) {
    suspend operator fun invoke(status: Boolean) = todoListRepository.filterTodoStatus(status)
}