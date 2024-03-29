package com.example.guideme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.guideme.components.ui.theme.GuideMeTheme

@Composable
fun SearchBar() {
    var query: String by rememberSaveable { mutableStateOf("") }

    TextField(
        value = query,
        onValueChange = { onQueryChanged ->
            query = onQueryChanged
            if (onQueryChanged.isNotEmpty()) {
                // Perform search
            }
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                tint = Color.LightGray,
                contentDescription = "Search icon",
            )
        },
        trailingIcon = { Icon(imageVector = Icons.Filled.FilterAlt, contentDescription = "Filter Icon", tint = Color.Black)},
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White),
        placeholder = { Text(text = "Search something") },
        textStyle = MaterialTheme.typography.subtitle1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.background, shape = RectangleShape)
    )
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GuideMeTheme {
        SearchBar()
    }
}