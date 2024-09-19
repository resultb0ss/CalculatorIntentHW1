package com.example.calculatorhw1

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private lateinit var toolbarMain: Toolbar

    private lateinit var firstOperandET: EditText
    private lateinit var secondOperandET: EditText


    private lateinit var buttonSumBTN: Button
    private lateinit var buttonDifBTN: Button



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



        buttonResetBTN = findViewById(R.id.buttonResetBTN)
        buttonExitBTN = findViewById(R.id.buttonExitBTN)

        resultTv = findViewById(R.id.resultTV)


        buttonDifBTN.setOnClickListener(::onClick)
        buttonSumBTN.setOnClickListener(::onClick)


        buttonResetBTN.setOnClickListener(::onClick)
        buttonExitBTN.setOnClickListener(::onClick)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.resetMenuMain -> {
                firstOperandET.text.clear()
                secondOperandET.text.clear()
                resultTv.text = "Результат"
                resultTv.setTextColor(Color.BLACK)
                myToast("Данные очищены")
            }
            R.id.exitMenuMain -> {
                myToast("Работа завершена")
                exitProcess(0)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun myToast(text: String){
        return Toast.makeText(
            applicationContext,
            text,
            Toast.LENGTH_LONG
        ).show()
    }

    private fun onClick(v: View){

        var check = true
        if(firstOperandET.text.isEmpty() || secondOperandET.text.isEmpty()){
            return
        }

        var first = firstOperandET.text.toString()
        var second = secondOperandET.text.toString()

        var result = when(v.id) {
            R.id.buttonSumBTN -> Operation(first,second).sum()
            R.id.buttonDifBTN -> Operation(first,second).dif()

            R.id.buttonResetBTN -> {
                firstOperandET.text.clear()
                secondOperandET.text.clear()
                resultTv.setTextColor(Color.BLACK)
                myToast("Данные очищены")
                check = false
            }

            R.id.buttonExitBTN -> {
                myToast("Работа завершена")
            }
            else -> 0.0
        }
        if(!check) resultTv.text = "Результат" else {
            resultTv.setTextColor(Color.parseColor("#8B0000"))
            resultTv.text = result.toString()
            myToast("Результат $result")
        }

    }
}