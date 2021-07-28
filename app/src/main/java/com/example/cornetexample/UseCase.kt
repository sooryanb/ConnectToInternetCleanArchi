package com.example.cornetexample

import com.example.core.usecases.AddTodo
import com.example.core.usecases.GetAllTodo
import com.example.core.usecases.GetTodo
import com.example.core.usecases.RemoveTodo

data class UseCase(
    val addTodo: AddTodo,
    val getAllTodo: GetAllTodo,
    val getTodo: GetTodo,
    val removeTodo: RemoveTodo
)