package com.example.cornetexample.framework.network

import com.example.cornetexample.Todo
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

        suspend fun getTodoFromRemote(): List<com.example.core.data.Todo> =

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
                val itemType = object : TypeToken<List<com.example.core.data.Todo>>() {}.type
                val todoList = gson.fromJson<List<com.example.core.data.Todo>>(result, itemType)

                todoList
            }
    }

}