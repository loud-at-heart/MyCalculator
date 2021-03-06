package com.example.mycalculator

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_calc.*
import kotlinx.android.synthetic.main.activity_recycler_view.*
import kotlinx.android.synthetic.main.calc_res_list_layout.*

class CalcActivity : AppCompatActivity() {

    var data = arrayListOf<String>()
    lateinit var adapter: WordAdapterCalc

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc)
        getSupportActionBar()?.hide() // Hiding the AppBar
//        recyclerViewCalc.layoutManager = LinearLayoutManager(this)
//        adapter = WordAdapterCalc(data)
//        recyclerViewCalc.adapter = adapter
    }

    var isNewOp=true
    var dot=false



    fun buNumberEvent(view: View) {

        if(isNewOp)
        {
            input.setText("")
        }
        isNewOp=false
        val buSelect= view as Button
        var buClickValue:String=input.text.toString()
        when(buSelect.id)
        {
            button_0.id->
            {
                buClickValue+="0"
            }
            button_1.id->
            {
                buClickValue+="1"
            }
            button_2.id->
            {
                buClickValue+="2"
            }
            button_3.id->
            {
                buClickValue+="3"
            }
            button_4.id->
            {
                buClickValue+="4"
            }
            button_5.id->
            {
                buClickValue+="5"
            }
            button_6.id->
            {
                buClickValue+="6"
            }
            button_7.id->
            {
                buClickValue+="7"
            }
            button_8.id->
            {
                buClickValue+="8"
            }
            button_9.id->
            {
                buClickValue+="9"
            }
            button_dot.id->
            {
                if(dot==false)
                {
                    buClickValue += "."
                }
                dot=true
            }
            button_plus_minus.id->
            {
                buClickValue="-" + buClickValue
            }
        }
        input.setText(buClickValue)

    }

    var op="??"
    var oldNumber=""

    fun buOpEvent(view: View) {
        val buSelect= view as Button
        when(buSelect.id)
        {
            button_multiply.id->
            {
                op="??"
            }
            button_division.id->
            {
                op="??"
            }
            button_subtraction.id->
            {
                op="-"
            }
            button_addition.id->
            {
                op="+"
            }
        }
        oldNumber=input.text.toString()
        isNewOp=true
        dot=false
    }
    fun buPercentEvent(view: View) {
        val number=(input.text.toString().toDouble())/100
        input.setText(number.toString())
        isNewOp=true
    }
    fun buCleanEvent(view: View) {
        input.setText("")
        output.setText("")
        viewer.setText("")
        isNewOp=true
        dot=false
    }
    fun buEqualEvent(view: View) {
        val newNumber=input.text.toString()
        var finalNumber:Double?=null
        when(op)
        {
            "??"->
            {
                finalNumber=oldNumber.toDouble() * newNumber.toDouble()
            }
            "??"->
            {
                finalNumber=oldNumber.toDouble() / newNumber.toDouble()
            }
            "-"->
            {
                finalNumber=oldNumber.toDouble() - newNumber.toDouble()
            }
            "+"->
            {
                finalNumber=oldNumber.toDouble() + newNumber.toDouble()
            }
        }
        if (finalNumber != null) {
            if (finalNumber.isNaN()) {
                // Show Error Message
//                input.setText("0.0")
//                output.setText("Error")
//                output.setTextColor(ContextCompat.getColor(this, R.color.red))
                val mBuilder = AlertDialog.Builder(this@CalcActivity)
                    .setTitle("Error")
                    .setMessage("$oldNumber $op $newNumber cannot be evaluated")
                    .setPositiveButton("ok"){
                            dialog, which ->
                        viewer.setText("")
                        input.setText("0")
                        output.setText("")
                    }.show()
                isNewOp=false
            } else {
                // Show Result
                viewer.setText("$oldNumber $op $newNumber ")
                input.setText(finalNumber.toString())
                output.setText(finalNumber.toString())
                output.setTextColor(ContextCompat.getColor(this, R.color.green))
//                data.add(tv_history.text.toString())
//                adapter.notifyDataSetChanged()
                isNewOp=true
            }
        }
    }

}