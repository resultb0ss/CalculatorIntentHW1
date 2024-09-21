package com.example.calculatorhw1

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculatorhw1.databinding.ActivitySecondBinding
import kotlin.system.exitProcess

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setSupportActionBar(binding.toolbarMain)

        binding.toolbarMain.title = "Калькулятор"
        binding.toolbarMain.subtitle = "версия 1"
        binding.toolbarMain.setLogo(R.drawable.baseline_calculate_24)

        binding.buttonDifBTN.setOnClickListener(::onClick)
        binding.buttonSumBTN.setOnClickListener(::onClick)
        binding.buttonMulBTN.setOnClickListener(::onClick)
        binding.buttonDevBTN.setOnClickListener(::onClick)

        binding.buttonResetBTN.setOnClickListener(::onClick)
        binding.buttonExitBTN.setOnClickListener(::onClick)

    }


    private fun myToast(text: String){
        return Toast.makeText(
            applicationContext,
            text,
            Toast.LENGTH_LONG
        ).show()
    }

    private fun onClick(view: View){

        var check = true
        if(binding.firstOperandEt.text.isEmpty() || binding.secondOperandEt.text.isEmpty()){
            return
        }

        var first = binding.firstOperandEt.text.toString().toDouble()
        var second = binding.secondOperandEt.text.toString().toDouble()

        var result = when(view) {
            binding.buttonSumBTN -> Operation(first,second).sum()
            binding.buttonDifBTN -> Operation(first,second).dif()
            binding.buttonDevBTN -> Operation(first,second).dev()
            binding.buttonMulBTN -> Operation(first,second).mul()

            binding.buttonResetBTN -> {
                binding.firstOperandEt.text.clear()
                binding.secondOperandEt.text.clear()
                binding.resultTV.setTextColor(Color.BLACK)
                myToast("Данные очищены")
                check = false
            }

            binding.buttonExitBTN -> {
                myToast("Работа завершена")
            }
            else -> 0.0
        }
        if(!check) binding.resultTV.text = "Результат" else {
            binding.resultTV.setTextColor(Color.parseColor("#8B0000"))
            binding.resultTV.text = result.toString()
            val intent = Intent()
            intent.putExtra("calcResult", result.toString())
            setResult(RESULT_OK,intent)
            finish()

        }

    }

}



