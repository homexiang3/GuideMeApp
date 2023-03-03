package com.example.guideme.components
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(var title:String, var icon: ImageVector, var screen_route:String){

    object Home : BottomNavItem("Home", Icons.Filled.Home,"home")
    object Itinerary: BottomNavItem("Itineraries",Icons.Filled.Map,"itineraries")
    object Favorite: BottomNavItem("Favorites",Icons.Filled.Favorite,"favorites")
    object Questionnaire: BottomNavItem("Quiz",Icons.Filled.Quiz,"questionnaire")
    object Profile: BottomNavItem("Profile",Icons.Filled.SupervisedUserCircle,"profile")
}