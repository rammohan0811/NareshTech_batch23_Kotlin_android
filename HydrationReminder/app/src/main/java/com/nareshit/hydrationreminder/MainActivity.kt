package com.nareshit.hydrationreminder

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var manager:AlarmManager
    lateinit var pi:PendingIntent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        manager = getSystemService(ALARM_SERVICE) as AlarmManager

    }

    fun cancelAlarm(view: View) {
        manager.cancel(pi)
    }

    fun scheduleAlarm(view: View) {
        // First Trigger time, interval time
        val firstTrigger = SystemClock.elapsedRealtime()
        val intervalTime:Long = 60*1000
         pi = PendingIntent.getBroadcast(this, 23,
            Intent(applicationContext,HydrationReceiver::class.java),PendingIntent.FLAG_MUTABLE)
        manager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME,firstTrigger,intervalTime,pi)
    }
}