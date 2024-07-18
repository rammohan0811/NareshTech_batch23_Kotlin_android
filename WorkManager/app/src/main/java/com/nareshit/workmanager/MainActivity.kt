package com.nareshit.workmanager

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequest
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

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

    fun startMyWork(view: View) {
        // Set up the constraints
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresBatteryNotLow(true)
            .build()
        // Now you can schedule the task
        val oneTimeWork = OneTimeWorkRequestBuilder<MyWork>()
            .setConstraints(constraints)
            .build()

        // to set up the periodic work
        val periodicWork = PeriodicWorkRequestBuilder<MyWork>(30,TimeUnit.DAYS,
            PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS, TimeUnit.MILLISECONDS)
            .setConstraints(constraints)
            .build()
        // You can scheule the onetime work using workmanager
        WorkManager.getInstance(this).enqueue(oneTimeWork)
    }

    // TODO 1: Add the dependencies in build.gradle (Module:app)
    // implementation("androidx.work:work-runtime-ktx:2.9.0")
    // TODO 2: Define the work
    // Create a class that extends to Worker class and override doWork(...) method.
    // TODO 3: Set up the constraints and also set up the Work
}