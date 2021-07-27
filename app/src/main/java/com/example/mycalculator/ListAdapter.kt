package com.example.mycalculator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mycalculator.model.Word
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter(var words: MutableList<Word>?) : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    //private var word= emptyList<Word>()
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = words?.get(position)
        holder.itemView.tv_id.text = currentItem?.uid.toString()
        holder.itemView.tv_word.text = currentItem?.title.toString()
    }

    override fun getItemCount(): Int {
        if(words == null){
            return 0
        }
        return words?.size!!
    }

    /*fun setData(word: List<Word>) {
        this.words = word
        notifyDataSetChanged()
    }*/
}