package com.nareshit.hydrationreminder

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat

class HydrationReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        // Send a notification to the users
        val manager:NotificationManager  = context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        // TODO 2: Create a notification channel
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            // Only for the devices that run android 8.0 and above, we create notificaiton channel
            val channel: NotificationChannel = NotificationChannel("pavan","My Noti Channel",
                NotificationManager.IMPORTANCE_HIGH)
            manager.createNotificationChannel(channel)
        }
        val notification: Notification = NotificationCompat.Builder(context,"pavan")
            /*.setSmallIcon(R.drawable.baseline_beach_access_24)*/
            .setSmallIcon(R.drawable.baseline_local_drink_24)
            .setContentTitle("Time to have some water")
            .setContentText("You must be hydrated. Have a glass of water")
            .setPriority(Notification.PRIORITY_HIGH)
            .setAutoCancel(true)
            .build()

        // Notify the user
        manager.notify(42,notification)
    }
}