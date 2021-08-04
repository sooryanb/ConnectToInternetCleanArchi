package com.example.cornetexample.core.data

import com.example.cornetexample.core.domain.BaseModel

abstract class DataSource<T: BaseModel> {
    abstract suspend fun add(item: T)

    abstract suspend fun get(id: Long): T?

    abstract suspend fun getAll(): List<T>

    abstract suspend fun remove(item: T)
}