package com.nareshit.jobscheduler

import android.app.job.JobParameters
import android.app.job.JobService
import android.widget.Toast

class MyJobService():JobService() {
    override fun onStartJob(params: JobParameters?): Boolean {
        // The actual Job that is to be performed has to be defined here
        Toast.makeText(this,"JobExecuted",Toast.LENGTH_LONG).show()
        return false
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        // The logic to stop the job in between has to written here
        return true
    }
}