package com.nareshit.powerreceiver

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    companion object{
        val CUSTOM_BROADCAST:String = "com.nareshit.powerreceiver.CUSTOM_BROADCAST"
    }

    lateinit var iv:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        iv = findViewById(R.id.imageView)
        val i:IntentFilter = IntentFilter()
        i.addAction(Intent.ACTION_POWER_CONNECTED)
        i.addAction(Intent.ACTION_POWER_DISCONNECTED)
        i.addAction(MainActivity.CUSTOM_BROADCAST)

        registerReceiver(MyPowerReceiver(iv),i)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(MyPowerReceiver(iv))
    }

    fun sendCustomBroadcast(view: View) {
        sendBroadcast(Intent(CUSTOM_BROADCAST))
    }
}

// TODO 1: Create a broadcast receiver (right click on new-> other -> create a broadcast receiver)
// TODO 2: Register the broadcasts that you are interested in (ACTION_POWER_CONNECTED, ACTION_POWER_DISCONNECTED)
// TODO 3: Unregister the broadcasts when you no longer need them
// TODO 4: Create images
// tODO 5: React to the broadcasts that are coming in the onReceive(...) method.

// For Custom Broadcast
// TODO 1: Come up with a unique string for which the interested components (can also be part of other apps)
//  can register
// TODO 2: Register for the custom broadcast
// TODO 3: use sendBroadcast(...) to send the broadcast
// TODO 4: Listen to this custom broadcast in your application (or in a different app)