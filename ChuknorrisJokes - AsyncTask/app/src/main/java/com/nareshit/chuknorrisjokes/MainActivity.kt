package com.nareshit.chuknorrisjokes

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
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

        textView = findViewById(R.id.joke_tv)
        progressBar = findViewById(R.id.progressBar)
        progressBar.indeterminateDrawable.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN)
        progressBar.visibility = View.INVISIBLE
    }

    fun fetchRandomJoke(view: View) {
        progressBar.visibility = View.VISIBLE
        FetchJoke(applicationContext,textView, progressBar).execute("https://api.chucknorris.io/jokes/random")
    }
}

// TODO 1: Add Internet Permission in the manifest file.
// TODO 2: Implement AsyncTask