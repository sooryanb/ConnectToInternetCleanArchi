package com.example.cornetexample.core.data

import com.example.cornetexample.core.domain.BaseModel

abstract class LocalRepository<T: BaseModel>(private val baseDao: BaseDao<T>): DataSource<T>() {
}