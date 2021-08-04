package com.example.cornetexample



data class NewUseCase(
    val addTodo: com.example.cornetexample.todolist.domain.usecase.AddTodo,
    val getAllTodo: com.example.cornetexample.todolist.domain.usecase.GetAllTodo
)