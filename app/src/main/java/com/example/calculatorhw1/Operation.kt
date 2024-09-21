package com.example.calculatorhw1

import android.widget.EditText

class Operation(private val first: Double, private val second: Double){

    fun sum() = first + second
    fun dif() = first - second
    fun dev() = first / second
    fun mul() = first * second


}