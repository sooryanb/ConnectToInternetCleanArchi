package com.example.cornetexample.core.data

import com.example.cornetexample.core.domain.BaseModel

abstract class RemoteRepository<T: BaseModel>(): DataSource<T>() {

}