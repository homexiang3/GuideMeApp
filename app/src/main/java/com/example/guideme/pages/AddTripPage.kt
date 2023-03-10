package com.example.guideme.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.guideme.R
import com.example.guideme.components.BackIcon

@Composable
fun AddTripPage(navController: NavController) {
    //Text fields variables
    val location = remember { mutableStateOf(TextFieldValue()) }
    val number = remember { mutableStateOf(TextFieldValue()) }
    val experience = remember { mutableStateOf(TextFieldValue()) }
    val starting = remember { mutableStateOf(TextFieldValue()) }
    val ending = remember { mutableStateOf(TextFieldValue()) }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp)
            .verticalScroll(rememberScrollState())
            .background(color=Color.White),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 15.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            BackIcon(onBack = {navController.popBackStack()})
            Text(
                text = "Back",
                modifier = Modifier.padding(start = 10.dp)
            )
        }
        //Title
        Text(
            text = "Add Trip",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier.padding(bottom = 30.dp)
        )
        //FORM
        Text(
            text = "I want to go to...",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
        )
        TextField(
            label = { Text(text = "Location") },
            value = location.value,
            onValueChange = { location.value = it })

        Text(
            text = "With this number of people",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            )
        TextField(
            label = { Text(text = "Number") },
            value = number.value,
            onValueChange = { number.value = it })


        Text(
            text = "I want to experience",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
        )
        TextField(
            label = { Text(text = "Experience Type") },
            value = experience.value,
            onValueChange = { experience.value = it })

        Text(
            text = "Starting on",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
        )
        TextField(
            label = { Text(text = "DD/MM/YY") },
            value = starting.value,
            onValueChange = { starting.value = it })
        Text(
            text = "And ending on",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
        )
        TextField(
            label = { Text(text = "DD/MM/YY") },
            value = ending.value,
            onValueChange = { ending.value = it })

        Button(
            onClick = {
                    navController.navigate("proposed")
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.red)),
            shape = RoundedCornerShape(50.dp),
            modifier = Modifier.fillMaxWidth().
                    padding(30.dp)
        ) {
            Text(text = "Generate", color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    AddTripPage(navController = rememberNavController())

}