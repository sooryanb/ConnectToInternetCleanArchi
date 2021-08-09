package com.example.cornetexample.todolist.data

import androidx.room.*
import com.example.cornetexample.core.data.BaseDao
import com.example.cornetexample.todolist.domain.model.TodoEntity

@Dao
interface TodoListDao: BaseDao<TodoEntity> {

    @Insert
    fun insertAll(todos: List<TodoEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTodoEntity(todos: List<TodoEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addTodoEntity(todo: TodoEntity)

    @Query("select * from todo_entity where id = :id")
    suspend fun getTodoEntity(id: Long): TodoEntity?

    @Query("select * from todo_entity")
    suspend fun getAllTodoEntities(): List<TodoEntity>

    @Delete
    suspend fun deleteTodoEntity(todo: TodoEntity)

    @Query("select * from todo_entity where title like :searchStr")
    suspend fun searchTodo(searchStr: String): List<TodoEntity>

    @Update
    fun updateTodo(todo: TodoEntity)

    @Query("select * from todo_entity where completed = :status")
    fun isCompleted(status: Boolean): List<TodoEntity>

}