package com.example.mycalculator

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.*
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadLocate()
        setContentView(R.layout.activity_main)

        bt_login.setOnClickListener {
            val username = et_username.text;
            val password = et_password.text;
//            Toast.makeText(this@MainActivity, password, Toast.LENGTH_SHORT).show()

//            if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
//                Toast.makeText(this@MainActivity, "Please Enter valid Username/Password", Toast.LENGTH_SHORT).show()
//            }
            if(username.toString().trim()=="pritam".trim()&&password.toString().trim()=="abc".trim()){
                startActivity(Intent(this,CalcActivity::class.java))
            }
            else{
                Toast.makeText(this@MainActivity, "Please Enter valid Username/Password", Toast.LENGTH_SHORT).show()
            }

        }

        bt_change_language.setOnClickListener{
            showChangeLang()
        }

    }

    private fun loadLocate() {
        val sharedPreferences = getSharedPreferences("Settings",Activity.MODE_PRIVATE)
        val language = sharedPreferences.getString("My_Lang","")
        if (language != null) {
            setLocate(language)
        }
    }

    private fun showChangeLang() {
        val listItems = arrayOf("বাংলা","English","हिंदी","தமிழ்")

        val mBuilder = AlertDialog.Builder(this@MainActivity)
        mBuilder.setTitle("Choose Language")
        mBuilder.setSingleChoiceItems(listItems,-1){
                dialog, which ->
            if (which==2){
                setLocate("hi")
                recreate()
            }
            else if (which==0){
                setLocate("bn")
                recreate()
            }
            else if(which==1){
                setLocate("en")
                recreate()
            }
            else if(which==3){
                setLocate("ta")
                recreate()
            }


            dialog.dismiss()
        }
        val mDialog = mBuilder.create()

        mDialog.show()
    }

    private fun setLocate(s: String) {
        val locale = Locale(s)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale

        baseContext.resources.updateConfiguration(config,baseContext.resources.displayMetrics)

        val editor = getSharedPreferences("Settings",Activity.MODE_PRIVATE).edit()
        editor.putString("My_Lang",s)
        editor.apply()

    }
}