package com.example.guideme
//External Imports
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
//Internal Imports
import com.example.guideme.components.BottomNavigation
import com.example.guideme.components.NavigationGraph
import com.example.guideme.components.TopBar
import com.example.guideme.pages.*
import com.example.guideme.ui.theme.GuideMeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GuideMeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreenView()
                }
            }
        }
    }
}

@Composable
fun MainScreenView(){
    val navController = rememberNavController()
    Scaffold(
        //Top bar
        topBar = { TopBar("Guide Me")},
        //Bottom bar
        bottomBar = { BottomNavigation(navController = navController) }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            //Invoke navigation graph to open content
            NavigationGraph(navController = navController)
        }
    }
}
