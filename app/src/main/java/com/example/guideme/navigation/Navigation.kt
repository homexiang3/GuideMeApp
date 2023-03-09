package com.example.guideme.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.guideme.UserInfo
import com.example.guideme.pages.HomePage
import com.example.guideme.pages.QuestionnairePage

sealed class Screens(val route: String) {
    object Home: Screens("home")
    object AddItinerary: Screens("add_itinerary")
    object Quiz: Screens("quiz")
    object GeneratedItineraries: Screens("generated_itineraries")
}

@Composable
fun NavGraph (navController: NavHostController,User: UserInfo){
    NavHost(
        navController = navController,
        startDestination = Screens.Home.route)
    {
        composable(route = Screens.Home.route){
            HomePage(User)
        }
        composable(route = Screens.Quiz.route){
            QuestionnairePage(User)
        }
    }
}