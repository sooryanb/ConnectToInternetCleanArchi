package com.example.cornetexample.todolist.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cornetexample.core.domain.BaseModel
import com.google.gson.annotations.SerializedName

@Entity(tableName = "todo_entity")
data class TodoEntity(
    @SerializedName("userId")
    val userId: Long = 0L,
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")val id: Long = 0L,
    @SerializedName("title")val title: String = "",
    @SerializedName("completed")val completed: Boolean = false
): BaseModel()
