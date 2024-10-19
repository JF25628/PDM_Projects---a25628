package com.example.calculator.Models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlin.math.sqrt

var valueOnDisplay by mutableStateOf("0")
var currentValue by mutableStateOf("")
var previousValue by mutableStateOf(" ")
var operation by mutableStateOf("")

fun onButtonClick(value: String){
    if(valueOnDisplay == "0" && value != "."){
        valueOnDisplay = value
        currentValue = value
    } else {
        valueOnDisplay += value
        currentValue += value
    }
}

fun clear() {
    valueOnDisplay = "0"
    currentValue = ""
    previousValue = ""
    operation = ""
}

fun clearEntry() {
    valueOnDisplay = valueOnDisplay.dropLast(1)
    if (valueOnDisplay.isEmpty()) {
        valueOnDisplay = "0"
    }
    currentValue = valueOnDisplay
}


fun setOperation(op: String) {
    if (currentValue.isNotEmpty()) {
        previousValue = currentValue
        currentValue = ""
        operation = op
    }
}

fun sqrtOperation(){
    if (currentValue.isNotEmpty()){
        var result = sqrt(currentValue.toDouble())

        valueOnDisplay = result.toString()
        currentValue = ""
        previousValue = ""
        operation = ""
    }
}

fun percentOperation(){
    if (currentValue.isNotEmpty()){
        var result= currentValue.toDouble() / 100

        valueOnDisplay = result.toString()
        currentValue = ""
        previousValue = ""
        operation = ""
    }
}

fun  calculateResult() {
    if (previousValue.isNotEmpty() && currentValue.isNotEmpty()){
        var result = when (operation){
            "+" -> previousValue.toDouble() + currentValue.toDouble()
            "-" -> previousValue.toDouble() - currentValue.toDouble()
            "x" -> previousValue.toDouble() * previousValue.toDouble()
            "/" -> previousValue.toDouble() / previousValue.toDouble()
            else -> valueOnDisplay.toDouble()
        }
        valueOnDisplay = result.toString()
        currentValue = ""
        previousValue = ""
        operation = ""
    }
}
