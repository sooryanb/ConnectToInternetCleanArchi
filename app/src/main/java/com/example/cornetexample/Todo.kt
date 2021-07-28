package com.example.cornetexample

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "todo")
data class Todo(
    @PrimaryKey(autoGenerate = true)
    val localId: Long = 0L,
    @SerializedName("userId")
    val userId: Long = 0L,
    @SerializedName("id")val id: Long = 0L,
    @SerializedName("title")val title: String = "",
    @SerializedName("completed")val completed: Boolean = false
)
