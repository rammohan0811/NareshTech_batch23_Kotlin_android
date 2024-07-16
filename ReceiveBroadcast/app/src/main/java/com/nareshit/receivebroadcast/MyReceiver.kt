package com.nareshit.receivebroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.TextView

class MyReceiver(val textView:TextView) : BroadcastReceiver() {

    companion object {
        const val CUSTOM_BROADCAST: String = "com.nareshit.powerreceiver.CUSTOM_BROADCAST"
    }
    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        if(intent.action == CUSTOM_BROADCAST){
            textView.text = "REceived the custom broadcast"
        }
    }
}