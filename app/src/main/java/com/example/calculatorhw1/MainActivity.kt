package com.example.calculatorhw1

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.example.calculatorhw1.databinding.ActivityMainBinding
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonResultBTN.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            launchSomeActivity.launch(intent)

        }

    }

    private val launchSomeActivity = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if(result.resultCode == RESULT_OK){
            val data = result.data
            val calcResult = data?.getStringExtra("calcResult")
            binding.programTitleTv.text = calcResult
            Toast.makeText(this,"$calcResult", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()
        }
    }
}
