package com.example.mycalculator

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WordAdapterCalc(private val data: ArrayList<String>): RecyclerView.Adapter<WordAdapterCalc.WordsViewHolder>() {
    class WordsViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val textviewhistory: TextView
        // Log.i(TAG,"WordsViewHolder")
        init {
            textviewhistory = itemView.findViewById(R.id.tv_history)
            var TAG = WordAdapterCalc::class.java.simpleName

            Log.i(TAG,"WordsViewHolder")

        }
    }

    var TAG = WordAdapterCalc::class.java.simpleName

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordsViewHolder {
        Log.i(TAG,"onCreateViewHolder--no of children currently rv"+parent.childCount)
        var view = LayoutInflater.from(parent.context).inflate(R.layout.calc_res_list_layout,parent,false)
        return WordAdapterCalc.WordsViewHolder(view)
    }

    override fun onBindViewHolder(holder: WordsViewHolder, position: Int) {
        Log.i(TAG,"onBindViewHolder--writing "+data[position])
        holder.textviewhistory.text = data[position]
    }

    override fun getItemCount(): Int {
        Log.i(TAG,"getItemCount-- counting no items remaing--"+data.size)

        return data.size
    }
}