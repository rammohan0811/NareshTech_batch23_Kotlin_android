package com.nareshit.jobscheduler

import android.app.job.JobInfo
import android.app.job.JobInfo.NETWORK_TYPE_ANY
import android.app.job.JobScheduler
import android.content.ComponentName
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.Job

class MainActivity : AppCompatActivity() {
    // TODO 1: Create a JobScheduler Object
    lateinit var jobScheduler: JobScheduler
    lateinit var jobInfo: JobInfo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        jobScheduler = getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler

        // TODO 2: Create a JobService Class where you will be defining a Task.
        // tODO 3:Define the Job Info to set the conditions when met to execute the job
        jobInfo = JobInfo.Builder(23, ComponentName(packageName,MyJobService::class.java.name))
            .setRequiredNetworkType(NETWORK_TYPE_ANY)
            .setRequiresCharging(false)
            .setPeriodic(15*60*1000)
            .build()
    }

    fun scheduleJob(view: View) {
        jobScheduler.schedule(jobInfo)
    }
}