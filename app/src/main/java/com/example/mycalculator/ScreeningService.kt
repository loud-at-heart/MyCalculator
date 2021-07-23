package com.example.mycalculator

import android.os.Build
import android.telecom.Call
import android.telecom.CallScreeningService
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.N)
public class ScreeningService : CallScreeningService()
{
    var TAG = ScreeningService::class.java.simpleName
    override fun onScreenCall(callDetails: Call.Details) {
        val phoneNumber = callDetails.handle.schemeSpecificPart
        Log.i(TAG,phoneNumber)
        // Do stuff with phone number
    }
}