package com.example.guideme.pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.guideme.component.CustomTopAppBar

@Composable
fun ForgotPassword(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = { CustomTopAppBar(
                navController = navController,
                title = "Forgot Password",
                showBackIcon = true
            )},
            content = {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val username = remember {
                        mutableStateOf(TextFieldValue())
                    }

                    Text(
                        text = "Forgot Password",
                        style = TextStyle(fontSize = 40.sp, fontFamily = FontFamily.Cursive)
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    TextField(
                        label = { Text(text = "Username") },
                        value = username.value,
                        onValueChange = { username.value = it }
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                        Button(
                            onClick = {},
                            shape = RoundedCornerShape(50.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                        ) {
                            Text(text = "Forgot Password")
                        }
                    }
                }
            }
        )
    }
}