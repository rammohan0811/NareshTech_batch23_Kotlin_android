package com.nareshit.powerreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.ImageView

class MyPowerReceiver(val imv:ImageView) : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        if(intent.action == Intent.ACTION_POWER_CONNECTED){
            imv.setImageResource(R.drawable.baseline_battery_charging_full_24)
        }else{
            imv.setImageResource(R.drawable.baseline_battery_alert_24)
        }
    }
}