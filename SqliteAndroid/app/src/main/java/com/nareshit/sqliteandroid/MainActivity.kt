package com.nareshit.sqliteandroid

import android.content.ContentValues
import android.database.Cursor
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var personName:EditText
    lateinit var personAge:EditText
    lateinit var result:TextView
    lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        personName = findViewById(R.id.person_name)
        personAge = findViewById(R.id.person_age)
        result = findViewById(R.id.textView)

        databaseHelper = DatabaseHelper(this)
    }

    fun loadData(view: View) {
        val c:Cursor = databaseHelper.loadData()
        // How do we traverse through the cursor
        c.moveToFirst()
        val sb:StringBuilder = StringBuilder()
        do{
            sb.append(c.getString(1))
            sb.append("\t")
            sb.append(c.getInt(2))
            sb.append("\n\n")
        }while (c.moveToNext())

        result.text = sb.toString()
    }
    fun saveData(view: View) {
        val n:String = personName.text.toString()
        val a:Int = personAge.text.toString().toInt()

        // TODO 1: Create the database table and also other required stuff
        // inorder to create a new database table(s), you need to create a class and extend it to SQLiteOpenHelper
        val values = ContentValues()
        values.put(DatabaseHelper.COL_1,n)
        values.put(DatabaseHelper.COL_2,a)

        databaseHelper.insertData(values)

        personName.text.clear()
        personAge.text.clear()

        Snackbar.make(view,"DATA INSERTED",Snackbar.LENGTH_LONG).show()
    }
}