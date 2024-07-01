package com.nareshit.fragbackstack

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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

    // By this method we override the functionality of the onBackPressed(...)
    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            val fragmentName = "Frag1" // Replace with actual fragment name
            val backEntry = supportFragmentManager.findFragmentByTag(fragmentName)
            if (backEntry != null) {
                supportFragmentManager.popBackStack(fragmentName,0) // Use popBackStackImmediate for smoother transition
                return
            }
        }
        super.onBackPressed()
    }
}