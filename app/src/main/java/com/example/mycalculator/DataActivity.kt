package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mycalculator.model.Word
import kotlinx.android.synthetic.main.activity_data.*

class DataActivity : AppCompatActivity() {
    lateinit var  roomDb: WordRoomDb
    lateinit var wordDao: WordDao
    lateinit var listAdapter: ListAdapter
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)
        roomDb = WordRoomDb.getDatabase(this)
        wordDao = roomDb.wordDao()
        listAdapter = ListAdapter(null)
        recyclerView = findViewById(R.id.db_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = listAdapter

        btn_data_save.setOnClickListener {
            insertWordAsynchronously()
            getDataAsync()
        }
        btn_delete.setOnClickListener {
            deleteWordAsynchronously()
            getDataAsync()
        }
        btn_del_word.setOnClickListener {
            deleteSpecificWordAsynchronously()
            getDataAsync()
        }
    }

    private fun deleteSpecificWordAsynchronously() {
        var data = et_data.text.toString()
        var deleteSpecificTask = DeleteWordTask(wordDao,data)
        deleteSpecificTask.execute()
    }

    private fun deleteWordAsynchronously() {
        var deleteTask = DeleteTask(wordDao)
        deleteTask.execute()
    }

    override fun onStart() {
        super.onStart()
        getDataAsync()
    }

    private fun getDataAsync() {
        var task = getDataTask(this,db_recycler_view,wordDao)
        task.execute()
    }

    private fun insertWordAsynchronously() {
        var data = et_data.text.toString()
        var word = Word(data)
        var insertTask = InsertTask(wordDao,word,listAdapter)
        insertTask.execute()
    }
}