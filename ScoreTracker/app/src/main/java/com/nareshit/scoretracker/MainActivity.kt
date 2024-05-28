package com.nareshit.scoretracker

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    // Declare an object for TextView
    lateinit var s:TextView
    var count:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Connect this object(.kt) to the view(.xml)
        s = findViewById(R.id.score)
        if(savedInstanceState!=null){
            count = savedInstanceState.getInt("MYVAL")
            s.setText(count.toString())
        }
    }

    // This function is called when the + button is clicked.
    fun incrementScore(view: View) {
        count++
        s.setText(count.toString())
    }
    // This function is called when the - button is clicked.
    fun decrementScore(view: View) {
        count--
        s.setText("$count")
    }

    // TODO 1: Override onSaveInstanceState(...) function
    //  This function helps us save the current instance of the activity
    //  so that the same instance can be used when the activity gets re-created.
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Here I would to save count variable's value for the next instance
        // You will be saving it in outstate Object.
        outState.putInt("MYVAL",count)
    }
}