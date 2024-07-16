package com.nareshit.powerreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.ImageView
import com.google.android.material.snackbar.Snackbar

class MyPowerReceiver(val imv:ImageView) : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        if(intent.action == Intent.ACTION_POWER_CONNECTED){
            imv.setImageResource(R.drawable.baseline_battery_charging_full_24)
        }else if(intent.action == Intent.ACTION_POWER_DISCONNECTED){
            imv.setImageResource(R.drawable.baseline_battery_alert_24)
        }else if(intent.action == MainActivity.CUSTOM_BROADCAST){
            Snackbar.make(imv,"Custom broadcast",Snackbar.LENGTH_LONG).show()
        }
    }
}