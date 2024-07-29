package com.nareshit.scoretrackermvvm

import android.database.DatabaseUtils
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.nareshit.scoretrackermvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.result.text = "${mainViewModel.count}"
        /*val plus:Button = binding.plusBtn*/
        binding.plusBtn.setOnClickListener {
            // Handle the plus button click
            mainViewModel.increment()
            binding.result.text = "${mainViewModel.count}"
        }

        binding.minusBtn.setOnClickListener {
            // Handle the minus button click
            mainViewModel.decrement()
            binding.result.text = "${mainViewModel.count}"
        }
    }
}