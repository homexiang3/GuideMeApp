package com.example.guideme.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.guideme.R
import com.example.guideme.UserInfo

@Composable
fun UserProfile(User:UserInfo) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .wrapContentSize(Alignment.Center)
            .padding(horizontal = 80.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "User Profile",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp
        )
        Icon(imageVector = Icons.Filled.AccountCircle, contentDescription = "User logo", modifier = Modifier.size(64.dp))
        Text(
            text = User.username,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Text(
            text = User.fullName
        )
        Text(
            text = User.email
        )
        Button(onClick = {},
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.red)),
            shape = RoundedCornerShape(50.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Filled.Edit,
                contentDescription ="Edit icon",
                modifier = Modifier.size(20.dp),
                tint = Color.White
            )
            Text(text = "Edit Profile",Modifier.padding(start = 10.dp),color = Color.White)
        }
        LogOutButton(User)
    }
}

@Composable
private fun LogOutButton(User:UserInfo) {
    Button(onClick = {
        User.isLogged = false
        User.username = ""
    },
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.red)),
        shape = RoundedCornerShape(50.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Filled.Logout,
            contentDescription ="Log out icon",
            modifier = Modifier.size(20.dp),
            tint = Color.White
        )
        Text(text = "Log out",Modifier.padding(start = 10.dp),color = Color.White)
    }
}
//Preview to see UI
@Preview(showBackground = true)
@Composable
fun UserProfilePreview() {
    var user = UserInfo(true,"TestUsername")
    UserProfile(user)
}
