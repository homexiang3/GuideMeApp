package com.example.guideme.pages

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Explore
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.guideme.R
import com.example.guideme.components.BackIcon
import com.example.guideme.pages.ui.theme.GuideMeTheme

@Composable
fun AddTripPage(navController: NavController) {
    Column {
        BackIcon(onBack = {navController.popBackStack()})
        Text(
            text = "add trip"
        )
        Button(
            onClick = {
                navController.navigate("proposed")
                println("AddItineraries")
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.red)),
            shape = RoundedCornerShape(50.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Explore,
                contentDescription = "",
                modifier = Modifier.size(20.dp),
                tint = Color.White
            )
            Text(text = "Add Itinerary", Modifier.padding(start = 10.dp), color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    AddTripPage(navController = rememberNavController())

}