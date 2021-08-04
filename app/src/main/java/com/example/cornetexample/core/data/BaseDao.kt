package com.example.cornetexample.core.data

import androidx.room.*
import com.example.cornetexample.core.domain.BaseModel

@Dao
interface BaseDao<T> where T: BaseModel {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(t: T)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(t: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(tList: Iterable<T>)

    @Delete
    suspend fun delete(t: T)


}