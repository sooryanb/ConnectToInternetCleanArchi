package com.example.cornetexample.todolist.data

import com.example.cornetexample.core.data.LocalRepository
import com.example.cornetexample.todolist.domain.model.TodoEntity

class TodoListLocalRepository(private val todoDao: TodoListDao): LocalRepository<TodoEntity>(todoDao) {
    override suspend fun add(item: TodoEntity) = todoDao.addTodoEntity(item)

    override suspend fun get(id: Long): TodoEntity? = todoDao.getTodoEntity(id)

    override suspend fun getAll(): List<TodoEntity> = todoDao.getAllTodoEntities()

    override suspend fun remove(item: TodoEntity) = todoDao.deleteTodoEntity(item)
}