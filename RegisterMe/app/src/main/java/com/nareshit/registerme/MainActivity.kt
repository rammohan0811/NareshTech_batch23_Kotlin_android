package com.nareshit.registerme

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var g = "Male"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val gender:RadioGroup = findViewById(R.id.gender)
        gender.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId == R.id.male){
                g = "Male"
            }else if(checkedId == R.id.female){
                g = "Female"
            }else{
                g = "Prefer neutral"
            }
        }
    }

    // When the button is pressed, you invoke this method
    fun getDetails(view: View) {
        // With the following line, you connected pn with person_name edit text box.
        val pn:EditText = findViewById(R.id.person_name)
        val pa:EditText = findViewById(R.id.person_age)
        val r:TextView = findViewById(R.id.result)
        // Read the contents
        // Every thing that you need out of a EditText box will be in String format
        val name:String = pn.text.toString()
        val age:Int = pa.text.toString().toInt()
        // To Display the data
        r.text = "$name $age $g"
    }
}