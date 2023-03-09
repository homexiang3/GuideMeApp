package com.example.guideme.components
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.guideme.R
import com.example.guideme.pages.*
import com.example.guideme.UserInfo

sealed class BottomNavItem(var title:String, var icon: ImageVector, var screen_route:String){

    object Home : BottomNavItem("Home", Icons.Filled.Home,"home")
    object Itinerary: BottomNavItem("Itineraries",Icons.Filled.Map,"itineraries")
    object Lists: BottomNavItem("Lists",Icons.Filled.List,"lists")
    object Profile: BottomNavItem("Profile",Icons.Filled.AccountCircle,"profile")
    object Quiz: BottomNavItem("Quiz",Icons.Filled.Quiz,"quiz")
    object AddItinerary: BottomNavItem("Add",Icons.Filled.Add,"add")
    object Proposed: BottomNavItem("Proposed",Icons.Filled.Map,"proposed")
}
@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Itinerary,
        BottomNavItem.Lists,
        BottomNavItem.Profile
    )
    androidx.compose.material.BottomNavigation(
        backgroundColor = colorResource(id = R.color.light_gray),
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(item.icon, contentDescription = item.title) },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 9.sp
                    )
                },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Black.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun NavigationGraph(navController: NavHostController, User:UserInfo) {
    NavHost(navController, startDestination = BottomNavItem.Home.screen_route) {
        composable(BottomNavItem.Home.screen_route) {
            HomePage(User, navController)
        }
        composable(BottomNavItem.Itinerary.screen_route) {
            ItinerariesPage()
        }
        composable(BottomNavItem.Lists.screen_route) {
            ListsPage()
        }
        composable(BottomNavItem.Profile.screen_route) {
            UserProfile(User,navController)
        }
        //not from bottom
        composable(BottomNavItem.Quiz.screen_route){
            QuestionnairePage(User,navController)
        }
        composable(BottomNavItem.AddItinerary.screen_route){
            AddTripPage(navController)
        }
        composable(BottomNavItem.Proposed.screen_route){
            ProposedItinerariesPage(navController)
        }
    }
}