package com.example.calculator.ui

import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text

@Composable
fun CustomButton(text: String, onclick: (String)->Unit){
    Button(
        onClick = {onclick(text)}
    ) {
        Text(text)
    }
}
