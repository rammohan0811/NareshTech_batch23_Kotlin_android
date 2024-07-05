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
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    lateinit var editText: EditText
    lateinit var textView:TextView
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

        editText = findViewById(R.id.search_query)
        textView = findViewById(R.id.textView)
        progressBar = findViewById(R.id.progressBar)
        progressBar.visibility = View.INVISIBLE
    }

    fun fetchBooks(view: View) {
        progressBar.visibility = View.VISIBLE
        val s:String = editText.text.toString()
        // Get data from a network call
        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(Request.Method.GET,
            "https://www.googleapis.com/books/v1/volumes?q=$s",
            { response->
                parseData(response)
                progressBar.visibility = View.INVISIBLE
            },
            { error ->
                textView.text = error.message
                progressBar.visibility = View.INVISIBLE
            })

        queue.add(stringRequest)
    }

    private fun parseData(response: String?) {
        // Perform JSON parsing
        val obj:JSONObject = JSONObject(response)
        val arr:JSONArray = obj.getJSONArray("items")
        textView.setText("")
        for(i in 0..arr.length()-1) {
            val item: JSONObject = arr.getJSONObject(i)
            val volInf:JSONObject = item.getJSONObject("volumeInfo")
            val t:String = volInf.getString("title")
            textView.append("$t\n\n")
        }
    }
}