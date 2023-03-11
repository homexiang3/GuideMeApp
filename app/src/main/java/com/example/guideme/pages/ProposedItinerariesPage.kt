package com.example.guideme.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.guideme.components.BackIcon

@Composable
fun ProposedItinerariesPage(navController: NavController) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp)
            .background(Color.White),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BackIcon(onBack = { navController.popBackStack() })
            Text(
                text = "Back",
                modifier = Modifier.padding(start = 10.dp),
                color = Color.Black
            )
        }
        //Title
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Proposed Itineraries",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                modifier = Modifier.padding(end = 10.dp),
                color = Color.Black
            )
            Icon(imageVector = Icons.Filled.FilterAlt, contentDescription = "Filter Icon", tint = Color.Black,
            modifier = Modifier.size(30.dp))
        }
        ProposedItinerariesList(dataList = customDataList)
    }
}

@Composable
fun ProposedItinerariesList(
    dataList : List<ItinerariesCardInfo>
){
    Column ( modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(dataList) { data ->
                ItineraryCard(data = data)
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    ProposedItinerariesPage(navController = rememberNavController())
}