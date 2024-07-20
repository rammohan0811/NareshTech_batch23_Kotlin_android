package com.nareshit.sharedpreferences

import android.content.SharedPreferences
import android.content.SharedPreferences.OnSharedPreferenceChangeListener
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(),OnSharedPreferenceChangeListener {
    lateinit var person_name:EditText
    lateinit var person_age:EditText
    lateinit var result:TextView
    // TODO 1: Create a shared Preferences file that is globally accessible for this class
    lateinit var sp:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        person_name = findViewById(R.id.person_name)
        person_age = findViewById(R.id.person_age)
        result = findViewById(R.id.textView)
        sp = getSharedPreferences("data_store", MODE_PRIVATE)
        sp.registerOnSharedPreferenceChangeListener(this)
    }

    fun saveData(view: View) {
        val name = person_name.text.toString()
        val age = person_age.text.toString().toInt()
        // TODO 2: Open the Editor to save data
        val e:SharedPreferences.Editor = sp.edit()
        e.putString("NAME",name)
        e.putInt("AGE",age)
        e.apply() // You can also call commit() which is not so thread friendly.
        // RESET the form
        person_name.text.clear()
        person_age.text.clear()
        person_name.clearFocus()
        person_age.clearFocus()
        Snackbar.make(view, "Data is Saved", Snackbar.LENGTH_LONG).show()
    }

    fun loadData(view: View) {
        // TODO 3: Load the data
        val n:String? = sp.getString("NAME","no name")
        val a:Int = sp.getInt("AGE",0)
        result.setText("$n $a")
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        val n:String? = sp.getString("NAME","no name")
        val a:Int = sp.getInt("AGE",0)
        result.setText("$n $a")
    }
}