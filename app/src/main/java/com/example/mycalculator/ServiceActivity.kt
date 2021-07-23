package com.example.mycalculator

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_service.*

class ServiceActivity : AppCompatActivity() {
    var TAG = ServiceActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)
    }

    fun handleServices(view: View) {
        when (view.id) {
            R.id.btn_bind -> {
                bindToaService()
            }
            R.id.btn_calendar ->{
                var intent = Intent("ineed.water")
                startActivity(intent)
            }
        }
    }

    private fun bindToaService() {
        var intent = Intent(this, LocalService::class.java)
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
    }

    var serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(p0: ComponentName?, binderPipe: IBinder?) {
            var localbider = binderPipe as LocalBinder
            var localService = localbider.getLocalService()
            var sum = localService.add(10, 20)
            Log.i(TAG,"sum = " + sum)
        }

        override fun onServiceDisconnected(p0: ComponentName?) {

        }
    }
}