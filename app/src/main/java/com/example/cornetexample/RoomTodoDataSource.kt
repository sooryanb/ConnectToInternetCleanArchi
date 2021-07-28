package com.example.cornetexample

import android.content.Context
import com.example.core.data.Todo
import com.example.core.repository.TodoDataSource
import com.example.cornetexample.framework.db.AppDatabase
import com.example.cornetexample.framework.db.TodoEntity

class RoomTodoDataSource(context: Context): TodoDataSource{

    private val todoDao = AppDatabase.getInstance(context).todoDoa

    override suspend fun add(todo: Todo) = todoDao.addTodoEntity(TodoEntity.fromTodo(todo))

    override suspend fun get(id: Long): Todo? = todoDao.getTodoEntity(id)?.toTodo()

    override suspend fun getAll(): List<Todo> = todoDao.getAllTodoEntities().map { it.toTodo() }

    override suspend fun remove(todo: Todo) = todoDao.deleteTodoEntity(TodoEntity.fromTodo(todo))
}