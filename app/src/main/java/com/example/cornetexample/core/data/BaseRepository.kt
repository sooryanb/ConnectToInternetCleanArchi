package com.example.cornetexample.core.data

import com.example.cornetexample.core.domain.BaseModel

abstract class BaseRepository<T: BaseModel> : DataSource<T>() {

    lateinit var localRepository: LocalRepository<T>
    lateinit var remoteRepository: RemoteRepository<T>

}