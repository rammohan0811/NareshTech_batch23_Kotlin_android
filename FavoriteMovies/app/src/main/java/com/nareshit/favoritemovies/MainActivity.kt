package com.nareshit.favoritemovies

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

data class MovieInfo(val poster:Int,val name:String, val actors:Array<String>)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // TODO 1: Set up the data properly
        val movies:List<MovieInfo> = listOf(
            MovieInfo(R.drawable.a,"ఆ ఆ", arrayOf("Nitin", "Samantha")),
            MovieInfo(R.drawable.b,"బాహుబలి", arrayOf("Prabhas","Anushka","Tamannah")),
            MovieInfo(R.drawable.c,"Cindrella", arrayOf("Lilly James","Richard Madden")),
            MovieInfo(R.drawable.d,"दंगल", arrayOf("Aamir Khan","Fatima", "Suhani")),
            MovieInfo(R.drawable.e,"Eega", arrayOf("Nani","Samantha")),
            MovieInfo(R.drawable.f,"F2", arrayOf("Venkatesh","Varun Tej")),
            MovieInfo(R.drawable.g,"Godavari", arrayOf("Sumanth","Kamilni")),
            MovieInfo(R.drawable.h,"Housefull", arrayOf("Akshay Kumar","Deepika")),
            MovieInfo(R.drawable.i,"IronMan", arrayOf("Robert","John")),
            MovieInfo(R.drawable.j,"Jungle Book", arrayOf("Jon","Neel"))
        )
        // TODO 2: Design the layout file (for each item - this design is going to be applied)
        // TODO 3: Add Recyclerview to the layout file and connect it on .kt file
        val rv:RecyclerView = findViewById(R.id.recyclerview)
        // TODO 4: Create an Adapter - view holder
        // TODO 5: attach the adapter
        val fma = FavMoviesAdapter(this,movies)
        rv.adapter = fma
        // tODO 6: Set up Layout Manager
        rv.layoutManager =
            LinearLayoutManager(this)
    }
}