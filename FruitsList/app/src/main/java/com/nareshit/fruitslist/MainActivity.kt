package com.nareshit.fruitslist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

data class Fruit(val name:String, val image:Int)

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
        // TODO 1: Connect the list view
        val lv:ListView = findViewById(R.id.listview)
        // TODO 2: Create an Array
        /*val fruits = arrayOf("Apple","Avocado","Apricot","Banana","Guava","Grapes","Mango","Water melon","Pineapple","Pomegranate","Sapota","Papaya","Muskmelon","Plum","Kiwi")*/
        // TODO 3: Create an ArrayAdapter to populate the data
        /*val adapter:ArrayAdapter<String> =
            ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1,fruits)*/
        // TODO 4: Set this adapter on the Listview
        /*lv.adapter = adapter*/

        // TODO 5: React to item click through an interface OnItemClickListener
        /*lv.setOnItemClickListener{parent,view,position, id ->
            val itemName = fruits[position]
            Snackbar.make(view,itemName,Snackbar.LENGTH_LONG).show()
        }*/

        // TODO 6: Customize the way the items are shown to the users
        // TODO 7: Download the images and put them in drawable folder
        // TODO 8: Create your custom layout to define how you want to
        //  display each item on the listview
        // TODO 9: Organize your data
        val fruits = arrayOf<Fruit>(Fruit("Apple", R.drawable.apple),
            Fruit("Apricot",R.drawable.apricot),
            Fruit("Avocado", R.drawable.avocado),
            Fruit("Banana", R.drawable.banana),
            Fruit("Grapes",R.drawable.grapes),
            Fruit("Guava",R.drawable.guava),
            Fruit("Kiwi",R.drawable.kiwi),
            Fruit("Mango", R.drawable.mango),
            Fruit("Muskmelon",R.drawable.muskmelon),
            Fruit("Papaya",R.drawable.papaya),
            Fruit("Plum",R.drawable.plum),
            Fruit("Pomegranate",R.drawable.pomegranate),
            Fruit("Sapota",R.drawable.sapota),
            Fruit("Watermelon",R.drawable.watermelon)
        )
        // Create a custom adapter
        val a:LVAdapter = LVAdapter(this, fruits)
        lv.adapter = a

        lv.setOnItemClickListener { parent, view, position, id ->
            Snackbar.make(view,fruits.get(position).name,Snackbar.LENGTH_LONG).show()
        }
    }

    class LVAdapter(val context:Context, val fruits:Array<Fruit>):BaseAdapter(){
        // Used to understand how many total items are there to display
        override fun getCount(): Int {
            return fruits.size
        }

        override fun getItem(position: Int): Any {
            return position
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        // This helps to populate the data on the layout and attach it to listview
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val v:View = LayoutInflater.from(context).inflate(R.layout.one_item_design,parent,false)
            val image:ImageView = v.findViewById(R.id.imageView)
            val fname:TextView = v.findViewById(R.id.fruit_name)
            image.setImageResource(fruits.get(position).image)
            fname.setText(fruits.get(position).name)
            return v
        }

    }
}