package com.nareshit.happybirthday

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private lateinit var startActivityResultLauncher:ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        startActivityResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){
                result:ActivityResult ->
            // When the result comes back, do something
            if(result.resultCode == Activity.RESULT_OK){
                val data:Intent? = result.data
                val d:String? = data?.getStringExtra("RESULT");
                Snackbar.make(findViewById(R.id.main),d!!,Snackbar.LENGTH_LONG).show()
            }
        }
    }

    fun wishHim(view: View) {
        // get data from TextInputLayout
        val til:TextInputLayout = findViewById(R.id.textField)
        val s = til.editText?.text.toString()
        val i:Intent = Intent(this,SecondActivity::class.java)
        // Now send this data as an extra value
        i.putExtra("DATA",s)
        startActivityResultLauncher.launch(i)
    }
}