package com.example.cornetexample.framework.network

import android.util.Log
import com.example.cornetexample.todolist.domain.model.TodoEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class Network {

    companion object {
        private const val remoteURL = "https://jsonplaceholder.typicode.com/todos/?userId=1"

        suspend fun getTodoFromRemote(): List<TodoEntity> =

            withContext(Dispatchers.IO) {
                val inputStream: InputStream

                // create URL
                val url: URL = URL(remoteURL)

                // create HttpURLConnection
                val conn: HttpURLConnection = url.openConnection() as HttpURLConnection

                // make GET request to the given URL
                conn.connect()

                // receive response as inputStream
                inputStream = conn.inputStream

                // convert inputstream to string
                val result = inputStream?.bufferedReader().use { it?.readText() } ?: "Did not work!"

                var gson = Gson()
                val itemType = object : TypeToken<List<TodoEntity>>() {}.type
                val todoList = gson.fromJson<List<TodoEntity>>(result, itemType)

                Log.d("TODO_DATA", "$todoList")

                todoList
            }
    }

}