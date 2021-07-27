package com.example.mycalculator

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.mycalculator.model.Word
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var  roomDb: WordRoomDb
    lateinit var wordDao: WordDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadLocate()
        setContentView(R.layout.activity_main)
        roomDb = WordRoomDb.getDatabase(this)
        wordDao = roomDb.wordDao()
        bt_login.setOnClickListener {
            val username = et_username.text;
            val password = et_password.text;

//            Toast.makeText(this@MainActivity, password, Toast.LENGTH_SHORT).show()

//            if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
//                Toast.makeText(this@MainActivity, "Please Enter valid Username/Password", Toast.LENGTH_SHORT).show()
//            }



            if(username.toString().trim()!="pritam".trim() && password.toString().trim()!="abc".trim()){
//                et_username.requestFocus()
                et_username.selectAll()
//                et_password.requestFocus()
                et_password.selectAll()
                Toast.makeText(this@MainActivity, "Please Enter valid Username and Password", Toast.LENGTH_SHORT).show()
            }
            else if(username.toString().trim()!="pritam".trim()){
                et_username.requestFocus()
                et_username.selectAll()
                Toast.makeText(this@MainActivity, "Please Enter valid Username", Toast.LENGTH_SHORT).show()
            }
            else if(password.toString().trim()!="abc".trim()){
                et_password.requestFocus()
                et_password.selectAll()
                Toast.makeText(this@MainActivity, "Please Enter valid Password", Toast.LENGTH_SHORT).show()
            }
            else{
                startActivity(Intent(this,CalcActivity::class.java))
            }


        }

        bt_change_language.setOnClickListener{
            showChangeLang()
        }

        bt_popup.setOnClickListener{
            val popup = PopupMenu(this@MainActivity,bt_popup)
            popup.inflate(R.menu.activity_menu_items)
            popup.setOnMenuItemClickListener {
                Toast.makeText(this,"Item :"+it.title,Toast.LENGTH_SHORT).show()
                true
            }
            popup.show()
        }

        btn_save.setOnClickListener {
            startActivity(Intent(this,DataActivity::class.java))
        }
    }


//    private fun insertWordAsynchronously() {
//        var data = et_username.text.toString()
//        var word = Word(data)
//        var insertTask = InsertTask(wordDao, word, listAdapter)
//        insertTask.execute()
//    }

    override fun onPause() {
        super.onPause()
//        saveTheData()
}

    private fun saveTheData() {
        //get value from edittext
        val text_usn = et_username.text.toString()
        val text_pwd = et_password.text.toString()
        //create a file
        var sharedPref = getSharedPreferences("userDet",Activity.MODE_PRIVATE)
        //put the value into the created file
        var editor = sharedPref.edit()
        editor.putString("usn",text_usn)
        editor.putString("pwd",text_pwd)
        editor.apply()
        //save the file
    }

    override fun onResume() {
        super.onResume()
//        getTheData()
    }

    private fun getTheData() {
        val sharedPreferences = getSharedPreferences("userDet",Activity.MODE_PRIVATE)
        val text_usn = sharedPreferences.getString("usn","")
        if (text_usn != null) {
            et_username.setText(text_usn)
        }
        val text_pwd = sharedPreferences.getString("pwd","")
        if (text_pwd != null) {
            et_password.setText(text_pwd)
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

    fun gotobleh(view: View) {
        startActivity(Intent(this,bleh::class.java))
    }
}