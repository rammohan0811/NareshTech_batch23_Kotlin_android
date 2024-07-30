package com.nareshit.roomdatabase

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import com.google.android.material.snackbar.Snackbar
import com.nareshit.roomdatabase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var amb:ActivityMainBinding
    lateinit var room:PersonRoomDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        amb = ActivityMainBinding.inflate(layoutInflater)
        val view:View = amb.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        room = Room.databaseBuilder(this,PersonRoomDatabase::class.java,"pavan")
            .allowMainThreadQueries().build()
    }

    fun saveData(view: View) {
        val name:String = amb.personName.text.toString()
        val age:Int = amb.personAge.text.toString().toInt()

        // You can put it in the database
        val p:Person = Person(0,name,age)
        room.personDao().insertData(p)
        Snackbar.make(view,"Data saved",Snackbar.LENGTH_LONG).show()
        amb.personAge.text.clear()
        amb.personName.text.clear()
    }
    fun loadData(view: View) {

    }
}