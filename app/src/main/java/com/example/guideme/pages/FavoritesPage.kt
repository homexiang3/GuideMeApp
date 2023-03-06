package com.example.guideme.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.guideme.components.SearchBar
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey

@Composable
fun FavoritesPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(8.dp)
    ) {
        Text(
            text = "Favorites",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(20.dp),
            textAlign = TextAlign.Center,
            fontSize = 20.sp

        )
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ){
            //SEARCHBAR FAKE
            SearchBar()
        }
        FavoritesList(dataList = customDataList)
    }
}
@Composable
fun FavoritesList(
    dataList : List<FavoritesCardInfo>
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(dataList) { data ->
            FavoriteCard(data = data)
        }
    }
}
data class FavoritesCardInfo(
    val name : String = "",
    val description: String = "",
    val picture: ImageVector = Icons.Filled.Image,
    val likeIcon: ImageVector = Icons.Filled.Favorite
)
private val customDataList = listOf(
    FavoritesCardInfo("Barcelona","Beautiful place to stay"),
    FavoritesCardInfo("Roma","Beautiful place to stay"),
    FavoritesCardInfo("London","Beautiful place to stay"),
    FavoritesCardInfo("Paris","Beautiful place to stay"),
    FavoritesCardInfo("Berlin","Beautiful place to stay")
)
@Composable
private fun FavoriteCard(data:FavoritesCardInfo){
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
                Column (){
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = data.likeIcon, contentDescription = "Favorite Icon", tint = Color.Red)
                    }
                }

            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun FavoritesPreview() {
    FavoritesPage()
}