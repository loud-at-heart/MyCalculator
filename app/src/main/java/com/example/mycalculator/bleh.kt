package com.example.mycalculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bleh.*

class bleh : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bleh)
        bt_change_color.setBackgroundColor(Color.RED)

        bt_change_color.setOnFocusChangeListener { _, b -> if(b)bt_change_color.setBackgroundColor(Color.YELLOW) }

        bt_change_color.setOnClickListener {
            bt_change_color.setBackgroundColor(Color.GREEN)
        }
    }
}