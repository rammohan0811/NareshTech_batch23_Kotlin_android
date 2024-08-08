package com.nareshit.servicesinandroid

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import android.provider.MediaStore.Audio.Media
import androidx.core.app.NotificationCompat

class MyForegroundService : Service() {

    lateinit var nm:NotificationManager
    lateinit var player:MediaPlayer

    override fun onBind(intent: Intent): IBinder {
        return null!!
    }

    override fun onCreate() {
        super.onCreate()
        player = MediaPlayer.create(this,R.raw.abc)
        nm = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // Logic to perform the foreground service
        // We will send a notification
        if(intent?.action == "MYACTION"){
            nm.cancel(32)
            player.stop()
            stopSelf()
        }else{
            player.start()
            sendNotification()
        }
        return START_NOT_STICKY
    }

    fun sendNotification(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel("pavan", "Service Notification", NotificationManager.IMPORTANCE_HIGH)
            nm.createNotificationChannel(channel)
        }
        val n = NotificationCompat.Builder(this,"pavan")
            .setContentTitle("My Foreground Service is started")
            .setContentText("Hello")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setAutoCancel(true)
            .build()
        nm.notify(23,n)
    }
}