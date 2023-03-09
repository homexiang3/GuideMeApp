package com.example.guideme.pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.guideme.R
import com.example.guideme.UserInfo
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun HomePage(User: UserInfo, navController: NavController) {
    val barcelona = LatLng(41.39, 2.15)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(barcelona, 5f)
    }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        ) {
              GenerateItineraries(User)
        }
        Row(
            Modifier
                .padding(horizontal = 24.dp, vertical = 24.dp)
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {navController.navigate("add")
                println("AddItineraries")},
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.red)),
                shape = RoundedCornerShape(50.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.AddBox,
                    contentDescription ="",
                    modifier = Modifier.size(20.dp),
                    tint = Color.White
                )
                Text(text = "Add Itinerary",Modifier.padding(start = 10.dp),color = Color.White)
            }
        }
    }
}
data class MarkersInfo(
    val position : LatLng,
    val title: String,
    val snippet: String,
)

@Composable
private fun markersListLogic(preferences:MutableList<Boolean>): List<MarkersInfo>{
    val markersList = remember {
        mutableStateListOf<MarkersInfo>()
    }
    markersList.add(MarkersInfo(LatLng(41.39, 2.15),"Barcelona Tour","Default Itinerary"))
    if(preferences[0]) {
        markersList.add(MarkersInfo(LatLng(47.37, 8.54), "Rafting Experience", "Adventure Itinerary"))
    }
    if(preferences[1]){
        markersList.add(MarkersInfo(LatLng(52.52, 13.41),"Berlin Business Trip","Business Itinerary"))
    }
    if(preferences[2]){
        markersList.add(MarkersInfo(LatLng(51.50, -0.13),"London Museums","Cultural Itinerary"))
    }
    if(preferences[3]){
        markersList.add(MarkersInfo(LatLng(48.86, 2.78),"Disneyland Paris","Familiar Itinerary"))
    }
    if(preferences[4]){
        markersList.add(MarkersInfo(LatLng(43.26, -2.93),"Tapas Tour","Gastronomic Itinerary"))
    }
    if(preferences[5]){
        markersList.add(MarkersInfo(LatLng(39.71, 2.99),"Mallorca Vacations","Relax Itinerary"))
    }
    if(preferences[6]){
        markersList.add(MarkersInfo(LatLng(41.61, 0.62),"Rural Catalonia","Rural Itinerary"))
    }
    return markersList

}
@Composable
private fun GenerateItineraries(User:UserInfo) {
    val dataList = markersListLogic(User.preferences)
    dataList.forEach { data ->
        Marker(
            state = MarkerState(position = data.position),
            title = data.title,
            snippet = data.snippet
        )
    }
}


