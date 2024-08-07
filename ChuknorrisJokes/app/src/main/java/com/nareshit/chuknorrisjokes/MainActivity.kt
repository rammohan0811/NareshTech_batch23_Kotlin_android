package com.nareshit.chuknorrisjokes

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.io.InputStream
import java.net.URL
import java.util.Scanner
import javax.net.ssl.HttpsURLConnection

class MainActivity : AppCompatActivity() {
    lateinit var textView:TextView
    lateinit var progressBar:ProgressBar

    // TODO 1 (for Coroutines): Define the scope of the coroutine
    lateinit var scope:CoroutineScope

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // TODO 1 (for Coroutines) Part 2
        scope = CoroutineScope(Dispatchers.Main)

        textView = findViewById(R.id.joke_tv)
        progressBar = findViewById(R.id.progressBar)
        progressBar.indeterminateDrawable.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN)
        progressBar.visibility = View.INVISIBLE
    }

    fun fetchRandomJoke(view: View) {
        progressBar.visibility = View.VISIBLE
        scope.launch {
            // This is where the coroutine is created.
            val data = fetchDataAsync()  // Create a new deferred object each time fetchRandomJoke Method is called
            try{
                val d = data.await()
                val jo: JSONObject = JSONObject(d)
                val value:String = jo.getString("value")
                textView.text = value
            }catch (e:Exception){
                e.printStackTrace()
            }finally {
                progressBar.visibility = View.INVISIBLE
            }
        }
    }

    private suspend fun fetchDataAsync():Deferred<String> = scope.async(Dispatchers.IO) {
        val url = URL("https://api.chucknorris.io/jokes/random")
        val urlConnection: HttpsURLConnection = url.openConnection() as HttpsURLConnection
        // from the connection that is created, read the data
        val ips: InputStream = urlConnection.inputStream
        Log.v("MAIN",ips.toString())
        val s: Scanner = Scanner(ips)
        val sb:StringBuilder = StringBuilder()
        while(s.hasNextLine()){
            sb.append(s.nextLine())
        }
        sb.toString()
    }
}

// TODO 1: Add Internet Permission in the manifest file.
// TODO 2: Implement AsyncTask