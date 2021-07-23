package com.example.mycalculator

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WordsAdapter(private val data: ArrayList<String>) : RecyclerView.Adapter<WordsAdapter.WordsViewHolder>() {
    var TAG = WordsAdapter::class.java.simpleName
    class WordsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textview: TextView
        // Log.i(TAG,"WordsViewHolder")
        init {
            textview = itemView.findViewById(R.id.tv_item)
            var TAG = WordsAdapter::class.java.simpleName

            Log.i(TAG,"WordsViewHolder")

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordsViewHolder {
        Log.i(TAG,"onCreateViewHolder--no of children currently rv"+parent.childCount)
        var view = LayoutInflater.from(parent.context).inflate(R.layout.list_layout,parent,false)
        return WordsViewHolder(view)
    }

    override fun onBindViewHolder(holder: WordsViewHolder, position: Int) {
        Log.i(TAG,"onBindViewHolder--writing "+data[position])
        holder.textview.text = data[position]
    }

    override fun getItemCount(): Int {
        Log.i(TAG,"getItemCount-- counting no items remaing--"+data.size)

        return data.size
    }

}