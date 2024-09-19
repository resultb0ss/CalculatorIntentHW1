package com.example.calculatorhw1

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var toolbarMain: Toolbar

    private lateinit var firstOperandET: EditText
    private lateinit var secondOperandET: EditText


    private lateinit var buttonSumBTN: Button
    private lateinit var buttonDifBTN: Button
    private lateinit var buttonMulBTN: Button
    private lateinit var buttonDevBTN: Button


    private lateinit var buttonResetBTN: Button
    private lateinit var buttonExitBTN: Button

    private lateinit var resultTv: TextView



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbarMain = findViewById(R.id.toolbarMain)
        setSupportActionBar(toolbarMain)
        toolbarMain.title = "Калькулятор"
        toolbarMain.subtitle = "версия 1"
        toolbarMain.setLogo(R.drawable.ic_android_black_24dp)

        firstOperandET = findViewById(R.id.firstOperandEt)
        secondOperandET = findViewById(R.id.secondOperandEt)


        buttonDifBTN = findViewById(R.id.buttonDifBTN)
        buttonSumBTN = findViewById(R.id.buttonSumBTN)
        buttonMulBTN = findViewById(R.id.buttonMulBTN)
        buttonDevBTN = findViewById(R.id.buttonDevBTN)


        buttonResetBTN = findViewById(R.id.buttonResetBTN)
        buttonExitBTN = findViewById(R.id.buttonExitBTN)

        resultTv = findViewById(R.id.resultTV)


        buttonDifBTN.setOnClickListener(::onClick)
        buttonSumBTN.setOnClickListener(::onClick)
        buttonMulBTN.setOnClickListener(::onClick)
        buttonDevBTN.setOnClickListener(::onClick)

        buttonResetBTN.setOnClickListener(::onClick)
        buttonExitBTN.setOnClickListener(::onClick)

    }




//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu_main, menu)
//        return true
//    }

    private fun onClick(v: View){

        var check = true
        if(firstOperandET.text.isEmpty() || secondOperandET.text.isEmpty()){
            return
        }

        var first = firstOperandET.text.toString().toDouble()
        var second = firstOperandET.text.toString().toDouble()

        var result = when(v.id) {
            R.id.buttonSumBTN -> Operation(first,second).sum()
            R.id.buttonDifBTN -> Operation(first,second).dif()
            R.id.buttonMulBTN -> Operation(first,second).mul()
            R.id.buttonDevBTN -> Operation(first,second).dev()
            R.id.buttonResetBTN -> {
                firstOperandET.text.clear()
                secondOperandET.text.clear()
                check = false
            }
            R.id.buttonExitBTN -> finish()
            else -> 0.0
        }
        if(!check) resultTv.text = "Результат" else {
            resultTv.setTextColor(Color.parseColor("#8B0000"))
            resultTv.text = result.toString()
        }

    }
}