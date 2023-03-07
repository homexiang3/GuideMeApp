package com.example.guideme
//External Imports
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
//Internal Imports
import com.example.guideme.components.BottomNavigation
import com.example.guideme.components.NavigationGraph
import com.example.guideme.components.TopBar
import com.example.guideme.pages.LoginPage
import com.example.guideme.ui.theme.GuideMeTheme

class UserInfo (
    isLogged:Boolean = false,
    username:String = "",
    fullName:String = "Pepito Garcia Villanueva",
    email:String = "pepito01@gmail.com",
    preferences:MutableList<Boolean> = mutableListOf(false,false,false,false,false,false,false)
){
    var isLogged by mutableStateOf(isLogged)
    var username by mutableStateOf(username)
    var preferences by mutableStateOf(preferences)
    //Hardcoded fullName - email
    val fullName = fullName
    val email = email
}
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
                    MainScreenView(UserInfo())
                }
            }
        }
    }
}

@Composable
fun MainScreenView(User:UserInfo){
    val navController = rememberNavController()
    if(!User.isLogged){
        LoginPage(User)
    } else {
        Scaffold(
            //Top bar
            topBar = { TopBar("Guide Me") },
            //Bottom bar
            bottomBar = { BottomNavigation(navController = navController) }
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                //Invoke navigation graph to open content
                NavigationGraph(navController = navController, User)
            }
        }
    }
}
