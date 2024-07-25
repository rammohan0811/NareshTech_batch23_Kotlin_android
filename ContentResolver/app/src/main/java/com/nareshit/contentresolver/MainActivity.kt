package com.nareshit.contentresolver

import android.content.ContentValues
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var result:TextView

    companion object{
        val DATABASE_NAME = "myDb"
        val TABLE_NAME = "person"
        val COL_0 = "person_id"
        val COL_1 = "person_name"
        val COL_2 = "person_age"
        val DATABASE_VERSION = 1
    }

    val AUTHORITY = "content://com.nareshit.sqliteandroid.CONTENT_PROVIDER"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        result = findViewById(R.id.result)

        // TODO 1: Create the URI for your contnet Provider
        val uri = Uri.parse(AUTHORITY)

        // TODO 2: Adding more data to the other app's database
        val values = ContentValues()
        values.put(COL_1,"Sujal")
        values.put(COL_2,23)

        contentResolver.insert(uri,values)



        val c = contentResolver.query(uri, null, null, null, null, null)
        c?.moveToFirst()
        val sb:StringBuilder = StringBuilder()
        do{
            sb.append(c?.getString(1))
            sb.append("\t")
            sb.append(c?.getInt(2))
            sb.append("\n\n")
        }while (c?.moveToNext()!!)

        result.text = sb.toString()
    }
}