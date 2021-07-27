package com.example.mycalculator

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_alarm.*

class AlarmActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {

    var NOTIFICATION_ID = 0
    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder: Notification.Builder
    val channelId = "i.apps.notifications"
    val description = "Test notification"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)

        alarmToggle.setOnCheckedChangeListener(this)

    }

    private fun deliverNotification() {
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationChannel = NotificationChannel(channelId, description, NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.GREEN
            notificationChannel.enableVibration(false)
            notificationManager.createNotificationChannel(notificationChannel)

            builder = Notification.Builder(this, channelId)
                .setSmallIcon(R.drawable.ic_stand_up)
                .setContentTitle(R.string.notification_title.toString())
                .setContentText(R.string.notification_text.toString())
                .setPriority(Notification.PRIORITY_HIGH)
                .setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.ic_launcher_background))
        } else {

            builder = Notification.Builder(this)
                .setSmallIcon(R.drawable.ic_stand_up)
                .setContentText("This is a notification message")
                .setPriority(Notification.PRIORITY_HIGH)
                .setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.ic_launcher_background))
        }
        notificationManager.notify(1234, builder.build())
    }

    override fun onCheckedChanged(p0: CompoundButton?, isChecked: Boolean) {
        if(isChecked){
            setAnAlarm(15000)
            deliverNotification()
        }
    }

    private fun setAnAlarm(i: Int) {

    }

}