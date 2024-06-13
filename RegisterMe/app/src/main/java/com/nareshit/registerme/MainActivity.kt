package com.nareshit.registerme

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.Checkable
import android.widget.CompoundButton
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener

class MainActivity : AppCompatActivity() {
    var g = "Male"
    var country = ""
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
        gender.setOnCheckedChangeListener(object: RadioGroup.OnCheckedChangeListener{
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                if(group?.checkedRadioButtonId == R.id.male){
                    g = "Male"
                }else if(group?.checkedRadioButtonId == R.id.female){
                    g = "Female"
                }else{
                    g = "Neutral"
                }
            }
        })

        val c:Spinner = findViewById(R.id.countries)
        /*val cs = listOf("Telangana","Andhra", "Maharastra","Bihar")
        val adapter:ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_list_item_1,cs)
        c.adapter = adapter*/
        val sk = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                country = parent?.getItemAtPosition(position).toString()

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        c.onItemSelectedListener = sk
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

        val tel:CheckBox = findViewById(R.id.telugu)
        val hin:CheckBox = findViewById(R.id.hindi)
        val eng:CheckBox = findViewById(R.id.english)
        val jap:CheckBox = findViewById(R.id.japanese)

        var lang = ""
        if(tel.isChecked) lang+="Telugu\t"
        if(hin.isChecked) lang+="Hindi\t"
        if(eng.isChecked) lang+="English\t"
        if(jap.isChecked) lang+="Japanese"

        val t:SwitchCompat = findViewById(R.id.scompat)
        var ts = false
        if(t.isChecked) ts = true
        // To Display the data
        r.text = "$name $age $g $lang $country $ts"
    }
}