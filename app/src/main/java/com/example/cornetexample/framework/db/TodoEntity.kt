package com.example.cornetexample.framework.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cornetexample.Todo
import com.google.gson.annotations.SerializedName

@Entity(tableName = "todo_entity")
data class TodoEntity(
    @SerializedName("userId")
    val userId: Long = 0L,
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")val id: Long = 0L,
    @SerializedName("title")val title: String = "",
    @SerializedName("completed")val completed: Boolean = false
){
    companion object{
        fun fromTodo(todo: com.example.core.data.Todo) = TodoEntity(todo.userId, todo.remoteId, todo.title, todo.completed)
    }

    fun toTodo() = com.example.core.data.Todo(userId, id, title, completed)
}
