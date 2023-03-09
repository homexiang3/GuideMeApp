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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
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
            .padding(horizontal = 70.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 50.dp)
        ){
            Icon(imageVector = Icons.Filled.AccountCircle, contentDescription = "User logo", modifier = Modifier.size(80.dp))
            Column (modifier = Modifier.padding(start = 10.dp)){
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
            }
        }
        Button(onClick = {},
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.light_gray)),
            shape = RoundedCornerShape(50.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Filled.Edit,
                contentDescription ="Edit icon",
                modifier = Modifier.size(20.dp),
            )
            Text(text = "Edit Profile",Modifier.padding(start = 10.dp))
        }
        Button(onClick = { /* TO DO CONNECT TO QUIZ*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.light_gray)),
            shape = RoundedCornerShape(50.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Filled.Quiz,
                contentDescription ="Quiz icon",
                modifier = Modifier.size(20.dp),
            )
            Text(text = "Modify Preferences",Modifier.padding(start = 10.dp))
        }
        Button(onClick = {},
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.light_gray)),
            shape = RoundedCornerShape(50.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Filled.Payments,
                contentDescription ="Payment icon",
                modifier = Modifier.size(20.dp),
            )
            Text(text = "Payment History",Modifier.padding(start = 10.dp))
        }
        Button(onClick = {},
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.light_gray)),
            shape = RoundedCornerShape(50.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Filled.Group,
                contentDescription ="Referral icon",
                modifier = Modifier.size(20.dp),
            )
            Text(text = "Referral status",Modifier.padding(start = 10.dp))
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
