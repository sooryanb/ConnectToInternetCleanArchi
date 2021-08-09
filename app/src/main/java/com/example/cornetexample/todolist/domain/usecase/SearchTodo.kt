package com.example.cornetexample.todolist.domain.usecase

import com.example.cornetexample.todolist.data.TodoListRepository

class SearchTodo (private val todoListRepository: TodoListRepository) {
    suspend operator fun invoke(searchString: String) = todoListRepository.search(searchString)
}