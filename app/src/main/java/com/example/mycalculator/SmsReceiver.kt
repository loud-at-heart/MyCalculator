package com.example.mycalculator

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager
import android.widget.Toast


class SmsReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, p1: Intent?) {

        try {
            val state: String? = p1?.getStringExtra(TelephonyManager.EXTRA_STATE)
            val incomingNumber: String? =
                p1?.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER)
            println("Receiver start")
            Toast.makeText(context, " Receiver start ", Toast.LENGTH_SHORT).show()
            if(state.equals(TelephonyManager.EXTRA_STATE_RINGING)){
                Toast.makeText(context,"Ringing State Number is -"+incomingNumber,Toast.LENGTH_SHORT).show();
            }
            if ((state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK))){
                Toast.makeText(context,"Received State",Toast.LENGTH_SHORT).show();
            }
            if (state.equals(TelephonyManager.EXTRA_STATE_IDLE)){
                Toast.makeText(context,"Idle State",Toast.LENGTH_SHORT).show();
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}