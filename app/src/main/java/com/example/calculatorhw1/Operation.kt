package com.example.calculatorhw1

import android.widget.EditText

class Operation(private val first: String, private val second: String){



    fun sum(): String {
        val result = stringSplit(first) + stringSplit(second)
        return stringDecode(result)
    }

    fun dif(): String {
        val result = stringSplit(first) - stringSplit(second)
        return stringDecode(result)
    }



    private fun stringSplit(str: String): Int{
        val splitArray = str.split("h","m","s")
        var hour = 0
        var min = 0
        var sec = 0
        if (splitArray.size == 4){
            hour = splitArray[0].toInt()
            min = splitArray[1].toInt()
            sec = splitArray[2].toInt()
        } else if (splitArray.size == 3){
            hour = 0
            min = splitArray[0].toInt()
            sec = splitArray[1].toInt()
        } else {
            hour = 0
            min = 0
            sec = splitArray[0].toInt()
        }
        var result = (hour * 3600) + (min * 60) + sec
        return result
    }

    private fun stringDecode(numSec: Int): String{
        var hour = numSec / 3600
        var min = (numSec - (3600 * hour)) / 60
        var sec = (numSec - (3600 * hour) - (60 * min))

        return "$hour" + "h" + "$min" + "m" + "$sec" + "s"
    }

}