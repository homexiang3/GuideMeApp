package com.example.guideme.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Group
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.guideme.R

//UNUSED
@Composable
fun ListsPage() {
    Box (
        modifier = Modifier.padding(vertical = 50.dp)
            .fillMaxWidth()
            ) {
        Text(
            text = "My Lists",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier.align(Alignment.Center)
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
            .background(Color.White)
            .padding(horizontal = 60.dp),
        verticalArrangement = Arrangement.spacedBy(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {},
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.light_gray)),
            shape = RoundedCornerShape(50.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Filled.Bookmark,
                contentDescription ="",
                modifier = Modifier.size(20.dp),
            )
            Text(text = "View Whishlist",Modifier.padding(start = 10.dp), fontSize = 20.sp)
        }
        Button(onClick = {},
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.light_gray)),
            shape = RoundedCornerShape(50.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription ="",
                modifier = Modifier.size(20.dp),
            )
            Text(text = "View Favorites",Modifier.padding(start = 10.dp), fontSize = 20.sp)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ListsPreview() {
    ListsPage()
}