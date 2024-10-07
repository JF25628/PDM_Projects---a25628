package com.example.calculator

import android.inputmethodservice.Keyboard.Row
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculator.ui.theme.CalculatorTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun Calculator() {

    val mCounter = remember { mutableStateOf(0)}

    Column() {

        Row ()
        {
            //Text("Login");
            TextField(value = "", onValueChange = {}, label = { Text(text = mCounter.value.toString()) })
            
            //TextField(valiue= "", onValueChange = {}, label = { Text(text = mCounter.value.toString(), fontSize = 50.dp)})
        }

        Row()
        {
            Column()
            {

                Row() {
                    CreateButton(7.toString(),) { mCounter.value += 5 }
                    CreateButton(8.toString(),) { }
                    CreateButton(9.toString(),) { }
                }

                Row() {
                    CreateButton(4.toString(),) { }
                    CreateButton(5.toString(),) { }
                    CreateButton(6.toString(),) { }
                }

                Row() {
                    CreateButton(1.toString(),) { }
                    CreateButton(2.toString(),) { }
                    CreateButton(3.toString(),) { }
                }

                Row() {
                    CreateButton(0.toString(),) { }
                    CreateButton(".",) { }
                    CreateButton("=",) { }
                }
            }

            Column() {
                CreateButton("/",) { }
                CreateButton("*",) { }
                CreateButton("+",) { }
                CreateButton("-",) { }
            }
        }

    }
}


@Composable
fun CreateButton(text: String, onClick:() -> Unit){
    Button(onClick = onClick) {
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