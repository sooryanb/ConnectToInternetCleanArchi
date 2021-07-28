package com.example.core.data

data class Todo(
    val userId: Long = 0L,
    val remoteId: Long = 0L,
    val title: String,
    val completed: Boolean
)