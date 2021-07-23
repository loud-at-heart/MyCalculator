package com.example.mycalculator

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class LocalService : Service() {
    private val binderPipe = LocalBinder()

    fun add(fno:Int,sno:Int):Int{
        return fno+sno
    }

    override fun onBind(p0: Intent?): IBinder? {
        return binderPipe
    }
}

class LocalBinder: Binder() {
    fun getLocalService():LocalService{
        return LocalService()
    }
}
