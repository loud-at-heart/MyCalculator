package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {
    var data = arrayListOf<String>()
    lateinit var adapter: WordsAdapter

    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = WordsAdapter(data)
        recyclerView.adapter = adapter
    }

    fun addToView(view: View) {
        var text = et_recycler_add_text.text.toString()
        //data.set(4,text)
        data.add(text)
        adapter.notifyDataSetChanged()
        fab_recycler_view.setVisibility(View.VISIBLE)
        et_recycler_add_text.setVisibility(View.INVISIBLE)
        bt_pass.setVisibility(View.INVISIBLE)
//        et_recycler_add_text.

    }

    fun fab(view: View) {
        fab_recycler_view.setVisibility(View.INVISIBLE)
        et_recycler_add_text.setVisibility(View.VISIBLE)
        bt_pass.setVisibility(View.VISIBLE)
    }
}