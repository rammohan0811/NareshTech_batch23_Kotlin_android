package com.nareshit.googlebooks

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var progressBar:ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        progressBar = findViewById(R.id.progressBar)
        recyclerView = findViewById(R.id.recyclerview)

        val sq = intent.getStringExtra("SEARCH")
        fetchBooks(sq!!)
    }

    private fun fetchBooks(s:String) {
        // Get data from a network call
        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(Request.Method.GET,
            "https://www.googleapis.com/books/v1/volumes?q=$s",
            { response->
                parseData(response)
                progressBar.visibility = View.INVISIBLE
            },
            { error ->

                progressBar.visibility = View.INVISIBLE
            })

        queue.add(stringRequest)
    }

    private fun parseData(response: String?) {
       val gson:Gson = Gson()
        val sd:Source = gson.fromJson(response,Source::class.java)
        val ba = BooksAdapter(applicationContext,sd)
        recyclerView.adapter = ba
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}