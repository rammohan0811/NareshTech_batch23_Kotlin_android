package com.nareshit.tabnavigation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

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

        val vp2 = findViewById<ViewPager2>(R.id.viewpager)
        val vpa2 = ViewPagerAdapter(this)
        vp2.adapter = vpa2

        val tl = findViewById<TabLayout>(R.id.tablayout)
        TabLayoutMediator(tl,vp2){tab,position->
            when(position){
                0 -> tab.setText("Red")
                1 -> tab.setText("Green")
                2 -> tab.setText("Blue")
            }
        }.attach()
    }

    class ViewPagerAdapter(fa:FragmentActivity):FragmentStateAdapter(fa){
        override fun getItemCount(): Int {
            return 3;
        }

        override fun createFragment(position: Int): Fragment {
            when(position){
                0 -> return RedFragment()
                1 -> return GreenFragment()
                2 -> return BlueFragment()
            }
            return RedFragment()
        }

    }
}