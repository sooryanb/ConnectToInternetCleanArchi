package com.example.cornetexample.todolist.domain.usecase


import com.example.cornetexample.todolist.data.TodoListRepository

class GetAllTodo(private val todoListRepository: TodoListRepository) {
    suspend operator fun invoke() = todoListRepository.getAll()
}

