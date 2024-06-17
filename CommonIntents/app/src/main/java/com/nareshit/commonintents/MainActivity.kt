package com.nareshit.commonintents

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputLayout

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

    }

    fun openMaps(view: View) {
        val address = findViewById<TextInputLayout>(R.id.textField)
        val data = address.editText?.text.toString()
        // How do you open your maps
        val i:Intent = Intent()
        // Now set the type of Action that you want to perform
        i.setAction(Intent.ACTION_VIEW)
        // Now set the data
        i.setData((Uri.parse("geo:0,0?q=$data")))
        // start the activity
        startActivity(i)
    }

    fun openDailer(view: View) {
        val pnum = findViewById<TextInputLayout>(R.id.textField2)
        val data = pnum.editText?.text.toString()
        // How do you open your maps
        val i:Intent = Intent()
        // Now set the type of Action that you want to perform
        i.setAction(Intent.ACTION_DIAL)
        // Now set the data
        i.setData((Uri.parse("tel:+91$data")))
        // start the activity
        startActivity(i)
    }
}