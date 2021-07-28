package com.example.cornetexample.framework.db

import androidx.room.*
import com.example.cornetexample.Todo

@Dao
interface TodoDao {
    @Insert
    fun insertAll(todos: List<Todo>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTodoEntity(todos: List<TodoEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addTodoEntity(todo: TodoEntity)

    @Query("select * from todo_entity where id = :id")
    suspend fun getTodoEntity(id: Long): TodoEntity?

    @Query("select * from todo_entity")
    suspend fun getAllTodoEntities(): List<TodoEntity>
    //TODO: Make this live data


    @Delete
    suspend fun deleteTodoEntity(todo: TodoEntity)
}
