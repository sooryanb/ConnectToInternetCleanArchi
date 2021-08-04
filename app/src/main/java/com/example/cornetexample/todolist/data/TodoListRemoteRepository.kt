package com.example.cornetexample.todolist.data

import com.example.cornetexample.core.data.RemoteRepository
import com.example.cornetexample.todolist.domain.model.TodoEntity
import com.example.cornetexample.framework.network.Network

class TodoListRemoteRepository: RemoteRepository<TodoEntity>() {

    override suspend fun add(item: TodoEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun get(id: Long): TodoEntity? {
        TODO("Not yet implemented")
    }

    override suspend fun getAll(): List<TodoEntity> {
        return Network.getTodoFromRemote()
    }

    override suspend fun remove(item: TodoEntity) {
        TODO("Not yet implemented")
    }
}