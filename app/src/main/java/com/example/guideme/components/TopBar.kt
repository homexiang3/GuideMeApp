package com.example.guideme.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.guideme.R

@Composable
fun TopBar(name:String) {
    TopAppBar(
        title = {
            Row ( horizontalArrangement = Arrangement.spacedBy(5.dp) ){
                Icon(imageVector = Icons.Filled.LocationOn, contentDescription = "GuideMe Logo", tint = colorResource(id = R.color.red) )
                Text(
                    text = name,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 20.sp
                )
            }
        },
        backgroundColor = Color.White
    )
}

