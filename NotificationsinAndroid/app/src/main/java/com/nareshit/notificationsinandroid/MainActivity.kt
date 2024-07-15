package com.nareshit.notificationsinandroid

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.NotificationManager.IMPORTANCE_HIGH
import android.app.PendingIntent
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationCompat.BigPictureStyle
import androidx.core.app.NotificationCompat.BigTextStyle
import androidx.core.app.NotificationManagerCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    // TODO 1: Create a NotificationManager Object and initialize it
    lateinit var manager:NotificationManager
    val NOTIFICATION_ID = 34
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        // TODO 2: Create a notification channel
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            // Only for the devices that run android 8.0 and above, we create notificaiton channel
            val channel:NotificationChannel = NotificationChannel("pavan","My Noti Channel",
                NotificationManager.IMPORTANCE_HIGH)
            manager.createNotificationChannel(channel)
        }
    }

    fun sendNotification(view: View) {
        // TODO 3: When this button is clicked, we send the notification

        // Step 1: Define what has happen when the notification is tapped
        val i:Intent = Intent(this,MainActivity::class.java)
        // Step 2: Wrap this up using Pending Intent Object's getActivity(...)
        val pi:PendingIntent = PendingIntent.getActivity(applicationContext, 23,i,
            PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE)

        // Convert JPEG image to Bitmap
        val b:Bitmap = BitmapFactory.decodeResource(resources,R.drawable.abc)
            /*.setStyle(BigPictureStyle().bigPicture(b))*/
        val notification:Notification = NotificationCompat.Builder(this,"pavan")
            .setSmallIcon(R.drawable.baseline_beach_access_24)
            .setContentTitle("You got a Notification")
            .setContentText("This is your message")
            .setPriority(Notification.PRIORITY_HIGH)
            .setContentIntent(pi)
            .addAction(R.drawable.baseline_beach_access_24, "Reply", pi)
            .addAction(R.drawable.baseline_beach_access_24, "Reply", pi)
            .setStyle(BigTextStyle().bigText("Android app development is quite easy to do\nAndroid app development is quite easy to do\nAndroid app development is quite easy to do\nAndroid app development is quite easy to do\nAndroid app development is quite easy to do\nAndroid app development is quite easy to do\nAndroid app development is quite easy to do\nAndroid app development is quite easy to do\nAndroid app development is quite easy to do\nAndroid app development is quite easy to do\nAndroid app development is quite easy to do\nAndroid app development is quite easy to do\nAndroid app development is quite easy to do\nAndroid app development is quite easy to do\nAndroid app development is quite easy to do\n"))
            .setAutoCancel(true)
            .build()

        // Notify the user
        manager.notify(NOTIFICATION_ID,notification)
    }
    fun cancelNotification(view: View) {
        // When this function invokes, we cancel the existing notifications
    }
}