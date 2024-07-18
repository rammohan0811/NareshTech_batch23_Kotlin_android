package com.nareshit.workmanager

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWork(val context:Context,val workerParameters: WorkerParameters): Worker(context,workerParameters){

    override fun doWork(): Result {
        val manager:NotificationManager = context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val channel = NotificationChannel("pavan","My Work",NotificationManager.IMPORTANCE_HIGH)
            manager.createNotificationChannel(channel)
        }
        val n = NotificationCompat.Builder(context,"pavan")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("Your Notification")
            .setContentText("Your Content Here")
            .build()
        manager.notify(23,n)
        return Result.success()
    }

}