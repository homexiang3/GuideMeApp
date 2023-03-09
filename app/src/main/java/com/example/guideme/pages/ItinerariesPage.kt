package com.example.guideme.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.guideme.R
import com.example.guideme.components.SearchBar

@Composable
fun ItinerariesPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(8.dp)
    ) {
        Text(
            text = "My Itineraries",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.align(Alignment.CenterHorizontally)
                .padding(20.dp),
            textAlign = TextAlign.Center,
            fontSize = 20.sp

        )
        Row (
            modifier = Modifier.fillMaxWidth().
                    padding(20.dp)
        ){
            //SEARCHBAR FAKE
            SearchBar()
        }
        ItinerariesList(dataList = customDataList)
    }
}
@Composable
fun ItinerariesList(
    dataList : List<ItinerariesCardInfo>
) {
    Column ( modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(dataList) { data ->
                ItineraryCard(data = data)
            }
        }
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.light_gray)),
            shape = RoundedCornerShape(50.dp),
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 50.dp)
        ) {
            Text(text = "View past itineraries")
        }
    }
}
data class ItinerariesCardInfo(
    val name : String = "",
    val description: String = "",
    val from: String = "",
    val to: String = "",
    val picture: ImageVector = Icons.Filled.Image,
)
val customDataList = listOf(
    ItinerariesCardInfo("Barcelona","Beautiful place to stay",
        "15/04/2023","19/04/2023"),
    ItinerariesCardInfo("London","Beautiful place to stay",
        "15/04/2023","19/04/2023"),
    ItinerariesCardInfo("Paris","Beautiful place to stay",
        "15/04/2023","19/04/2023"),
    ItinerariesCardInfo("Berlin","Beautiful place to stay",
        "15/04/2023","19/04/2023"),
    ItinerariesCardInfo("Roma","Beautiful place to stay",
        "15/04/2023","19/04/2023"),
    ItinerariesCardInfo("Kiev","Beautiful place to stay",
        "15/04/2023","19/04/2023"),
    ItinerariesCardInfo("Berlin","Beautiful place to stay",
        "15/04/2023","19/04/2023"),
    ItinerariesCardInfo("Roma","Beautiful place to stay",
        "15/04/2023","19/04/2023"),
    ItinerariesCardInfo("Kiev","Beautiful place to stay",
        "15/04/2023","19/04/2023")
)
@Composable
fun ItineraryCard(data:ItinerariesCardInfo){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                //open itinerary details
            },
        shape = RoundedCornerShape(10.dp),
        backgroundColor = Color.LightGray

    ) {
        Row {
            Icon(
                imageVector = data.picture,
                contentDescription = "User logo",
                modifier = Modifier.size(64.dp)
            )
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = data.name,
                        modifier = Modifier.padding(5.dp),
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    )
                    Text(
                        text = data.description,
                    )
                }
                Column (modifier = Modifier.padding(2.dp)){
                    Text(
                        text = "From: ${data.from}",
                        fontSize = 10.sp
                    )
                    Text(
                        text = "To: ${data.to}",
                        fontSize = 10.sp
                    )
                }

            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ItinerariesPreview() {
    ItinerariesPage()
}