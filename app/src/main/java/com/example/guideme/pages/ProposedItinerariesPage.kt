package com.example.guideme.pages

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.guideme.components.BackIcon
import com.example.guideme.pages.ui.theme.GuideMeTheme

@Composable
fun ProposedItinerariesPage(navController: NavController) {
    Column {
        BackIcon(onBack = { navController.popBackStack() })
        Text(
            text = "proposed itineraries"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    ProposedItinerariesPage(navController = rememberNavController())
}