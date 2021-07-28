package com.example.cornetexample.framework.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import androidx.core.view.isGone
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cornetexample.R
import com.example.cornetexample.Todo
import com.example.cornetexample.framework.db.AppDatabase
import com.example.cornetexample.framework.db.TodoEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity(), TodoView {

    private lateinit var presenter: ToDoPresenter

    private lateinit var progressBar: ProgressBar
    private lateinit var todoRecyclerView: RecyclerView

//    fun JSONObject.toMap(): Map<String, *> = keys().asSequence().associateWith {
//        Log.d("REQUESTT", "bleh : ${this[it]}")
//        when (val value = this[it])
//        {
//            is JSONArray ->
//            {
//                val map = (0 until value.length()).associate { Pair(it.toString(), value[it]) }
//                JSONObject(map).toMap().values.toList()
//            }
//            is JSONObject -> value.toMap()
//            JSONObject.NULL -> null
//            else            -> value
//        }
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = ToDoPresenter(this, application)


        progressBar = findViewById(R.id.loadingView)
        todoRecyclerView = findViewById(R.id.recyclerView)


//        val jsonString = "{ '_id' : { 'oid' : '593440eb7fa580d99d1abe85'},'name' : 'Firstname Secondname' ," +
//                "'reg_number' : 'ATC/DCM/1016/230' , 'oral' : 11}"
//
//
//        val jsonObj = JSONObject(jsonString)
//        val map = jsonObj.toMap()
//        Log.d("REQUESTT", "$map")
//

    }

    override fun showProgress() {
        progressBar = findViewById(R.id.loadingView)
        progressBar.isGone = false
    }

    override fun hideProgress() {
        progressBar = findViewById(R.id.loadingView)
        progressBar.isGone = true
    }

    override fun loadTodoData(todoList: List<com.example.core.data.Todo>) {
        todoRecyclerView = findViewById(R.id.recyclerView)
        val adapter = TodoItemAdapter(todoList)
        todoRecyclerView.adapter = adapter
        todoRecyclerView.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
    }




//    private fun loadData(){
//
//
//        val queue = Volley.newRequestQueue(this)
//        val url = "https://jsonplaceholder.typicode.com/todos/?userId=1"
//
//        val stringRequest = StringRequest(Request.Method.GET, url,
//            Response.Listener<String> { response ->
//
//                var gson = Gson()
//                val itemType = object : TypeToken<List<Todo>>() {}.type
//                val todoList = gson.fromJson<List<Todo>>(response, itemType)
//
//                GlobalScope.launch {
//                 insertData(todoList)
//                }
//
//                val todoRecyclerView = findViewById<RecyclerView>(R.id.recyclerView)
//                val adapter = TodoItemAdapter(todoList)
//                todoRecyclerView.adapter = adapter
//                todoRecyclerView.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
//
//            },
//            Response.ErrorListener {  Log.d("REQUEST",  "Error ") })
//
//        queue.add(stringRequest)
//
//    }

//    private suspend fun insertData(todoList: List<Todo>) {
//        withContext(Dispatchers.IO){
//            appDB.todoDoa.insertAll(todoList)
//            for (todo in todoList){
//                appDB.todoDoa.addTodoEntity(TodoEntity(todo.userId, todo.id, todo.title, todo.completed))
//            }
//        }
//    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }


}