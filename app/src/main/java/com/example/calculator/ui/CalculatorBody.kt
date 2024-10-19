import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.Models.calculateResult
import com.example.calculator.Models.clear
import com.example.calculator.Models.clearEntry
import com.example.calculator.Models.onButtonClick
import com.example.calculator.Models.percentOperation
import com.example.calculator.Models.setOperation
import com.example.calculator.Models.sqrtOperation
import com.example.calculator.Models.valueOnDisplay
import com.example.calculator.ui.Screen

@Composable
fun CalculatorBody(){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {

        //screen

        Screen("0")
        /*
        Text(
            text = valueOnDisplay,
            modifier = Modifier
                .fillMaxWidth()
                .padding(1.dp),
            fontSize = 32.sp,
            textAlign = TextAlign.Right
        )
        */

        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {

            Button(
                onClick = { sqrtOperation() },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
            ) {
                Text("√", color = Color.White)
            }

            Button(
                onClick = { percentOperation() },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
            )
            {
                Text("%", color = Color.White)
            }

            Button(
                onClick = { clear() },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
            )
            {
                Text("C", color = Color.White)
            }

            Button(
                onClick = { clearEntry() },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
            )
            {
                Text("CE", color = Color.White)
            }

        }


        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth() // Make the row fill the width of the screen
        ) {
            Column(modifier = Modifier.weight(1f))
            {
                Button(
                    onClick = { onButtonClick("7") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
                )
                {
                    Text("7", color = Color.White)
                }

                Button(
                    onClick = { onButtonClick("4") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
                )
                {
                    Text("4", color = Color.White)
                }

                Button(
                    onClick = { onButtonClick("1") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
                )
                {
                    Text("1", color = Color.White)
                }

                Button(
                    onClick = { onButtonClick("0") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
                )
                {
                    Text("0", color = Color.White)
                }
            }

            Column(modifier = Modifier.weight(1f))
            {
                Button(
                    onClick = { onButtonClick("8") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
                )
                {
                    Text("8", color = Color.White)
                }

                Button(
                    onClick = { onButtonClick("5") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
                )
                {
                    Text("5", color = Color.White)
                }
                Button(
                    onClick = { onButtonClick("2") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
                )
                {
                    Text("2", color = Color.White)
                }
                Button(
                    onClick = { onButtonClick(".") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
                )
                {
                    Text(".", color = Color.White)
                }
            }

            Column(modifier = Modifier.weight(1f)) {
                Button(
                    onClick = { onButtonClick("9") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
                )
                {
                    Text("9", color = Color.White)
                }
                Button(
                    onClick = { onButtonClick("6") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
                )
                {
                    Text("6", color = Color.White)
                }
                Button(
                    onClick = { onButtonClick("3") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
                )
                {
                    Text("3", color = Color.White)
                }

                Button(
                    onClick = { calculateResult() },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
                )
                {
                    Text("=", color = Color.White)
                }
            }

            Column(modifier = Modifier.weight(1f)) {
                Button(
                    onClick = { setOperation("/") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
                )
                {
                    Text("÷", color = Color.White)
                }

                Button(
                    onClick = { setOperation("x") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
                )
                {
                    Text("x", color = Color.White)
                }
                Button(
                    onClick = { setOperation("-") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
                )
                {
                    Text("-", color = Color.White)
                }
                Button(
                    onClick = { setOperation("+") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
                )
                {
                    Text("+", color = Color.White)
                }
            }
        }
    }
}
