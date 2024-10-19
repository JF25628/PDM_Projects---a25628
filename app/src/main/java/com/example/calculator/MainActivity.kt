package com.example.calculator

import CalculatorBody
import android.inputmethodservice.Keyboard.Row
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.CalculatorTheme
import org.w3c.dom.Text
import androidx.compose.foundation.layout.fillMaxWidth
import kotlin.math.sqrt




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                    CalculatorBody()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun calculatorPreview() {
    CalculatorTheme {
        CalculatorBody()
    }
}


/*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                    Calculator()
            }
        }
    }
}
@Composable
fun Calculator() {

    var valueOnDisplay by remember { mutableStateOf("0") }
    var currentValue by remember { mutableStateOf("") }
    var previousValue by remember { mutableStateOf(" ") }
    var operation by remember { mutableStateOf("") }

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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(
            text = valueOnDisplay,
            modifier = Modifier
                .fillMaxWidth()
                .padding(1.dp),
            fontSize = 32.sp,
            textAlign = TextAlign.Right
        )

        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            CreateButton(
                "√", onClick = { sqrtOperation() },
                backGroundColors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                ),
                modifier = Modifier.weight(1f)

            )
            CreateButton(
                "%", onClick = { percentOperation() },
                backGroundColors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                ),
                modifier = Modifier.weight(1f)
            )
            CreateButton(
                "C", onClick = { clear() },
                backGroundColors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
                    contentColor = Color.White
                ),
                modifier = Modifier.weight(1f)
            )
            CreateButton(
                "CE", onClick = { clearEntry() },
                backGroundColors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
                    contentColor = Color.White
                ),
                modifier = Modifier.weight(1f)
            )
        }


        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth() // Make the row fill the width of the screen
        ) {
            Column(modifier = Modifier.weight(1f)) {
                CreateButton(
                    "7", onClick = { onButtonClick("7") },
                    backGroundColors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray,
                        contentColor = Color.White
                    )
                )
                CreateButton(
                    "4", onClick = { onButtonClick("4") },
                    backGroundColors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray,
                        contentColor = Color.White
                    )
                )
                CreateButton(
                    "1", onClick = { onButtonClick("1") },
                    backGroundColors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray,
                        contentColor = Color.White
                    )
                )
                CreateButton(
                    "0", onClick = { onButtonClick("0") },
                    backGroundColors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray,
                        contentColor = Color.White
                    )
                )
            }

            Column(modifier = Modifier.weight(1f)) {
                CreateButton(
                    "8", onClick = { onButtonClick("8") },
                    backGroundColors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray,
                        contentColor = Color.White
                    )
                )
                CreateButton(
                    "5", onClick = { onButtonClick("5") },
                    backGroundColors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray,
                        contentColor = Color.White
                    )
                )
                CreateButton(
                    "2", onClick = { onButtonClick("2") },
                    backGroundColors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray,
                        contentColor = Color.White
                    )
                )
                CreateButton(
                    ".", onClick = { onButtonClick(".") },
                    backGroundColors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray,
                        contentColor = Color.White
                    )
                )
            }

            Column(modifier = Modifier.weight(1f)) {
                CreateButton(
                    "9", onClick = { onButtonClick("9") },
                    backGroundColors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray,
                        contentColor = Color.White
                    )
                )
                CreateButton(
                    "6", onClick = { onButtonClick("6") },
                    backGroundColors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray,
                        contentColor = Color.White
                    )
                )
                CreateButton(
                    "3", onClick = { onButtonClick("3") },
                    backGroundColors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray,
                        contentColor = Color.White
                    )
                )
                CreateButton(
                    "=", onClick = { calculateResult() },
                    backGroundColors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                        contentColor = Color.White
                    )
                )
            }

            Column(modifier = Modifier.weight(1f)) {
                CreateButton(
                    "÷", onClick = { setOperation("/") },
                    backGroundColors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                        contentColor = Color.White
                    )
                )
                CreateButton(
                    "x", onClick = { setOperation("x") },
                    backGroundColors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                        contentColor = Color.White
                    )
                )
                CreateButton(
                    "-", onClick = { setOperation("-") },
                    backGroundColors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                        contentColor = Color.White
                    )
                )
                CreateButton(
                    "+", onClick = { setOperation("+") },
                    backGroundColors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                        contentColor = Color.White
                    )
                )
            }
        }
    }
}


@Composable
fun CreateButton(text: String, onClick:() -> Unit, backGroundColors: ButtonColors, modifier: Modifier = Modifier){
    Button(onClick = onClick, colors = backGroundColors, modifier = modifier
        .fillMaxWidth()
        .height(80.dp)
        .padding(4.dp)) {
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculatorTheme {
        //CreateButton(1.toString(),) { }
        Calculator()
    }
}
*/