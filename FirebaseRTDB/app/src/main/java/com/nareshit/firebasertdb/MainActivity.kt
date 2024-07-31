package com.nareshit.firebasertdb

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.nareshit.firebasertdb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    lateinit var firebaseReference:DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val v:View = binding.root
        setContentView(v)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        firebaseReference = Firebase.database.getReference("Person")
        binding.progressBar.visibility = View.INVISIBLE
    }

    data class Person(val name:String, val age:Int)

    fun saveData(view: View) {
        binding.progressBar.visibility = View.VISIBLE
        val name:String = binding.personName.text.toString()
        val age:Int = binding.personAge.text.toString().toInt()
        val p:Person = Person(name, age)

        firebaseReference.push().setValue(p).addOnSuccessListener {
            binding.progressBar.visibility = View.INVISIBLE
            Snackbar.make(view,"Data Saved Successfully", Snackbar.LENGTH_LONG).show()
        }

        binding.personName.text.clear()
        binding.personAge.text.clear()
    }
    fun loadData(view: View) {}
}