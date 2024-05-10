package com.example.thigiuaki.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.thigiuaki.R


@Composable
fun Home_Screen(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp)) {
        Row {
            Text(text = "Hungry? Choose a dish...", style = MaterialTheme.typography.headlineMedium)
            Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = null )
        }
        TextField(value = "",
            onValueChange ={},
            placeholder = {Text(text ="What's cooking in your mind...?", modifier = Modifier.alpha(0.4f))},
            trailingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = null )
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 7.dp)
            )
        Row(modifier = Modifier.padding(top=16.dp)) {
            Text(text = "Trending Today", style = MaterialTheme.typography.titleLarge,modifier = Modifier
                .padding(top = 4.dp)
                .padding(start = 7.dp))
            TextButton(onClick = { /*TODO*/ }, modifier = Modifier
                .padding(start = 132.dp)
                .fillMaxWidth()) {
                Text(text = "see all")
            }
        }
        Row(modifier = Modifier.padding(top=16.dp), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = null,Modifier.width(100.dp))
            Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = null,Modifier.width(100.dp))

        }
        Row(modifier = Modifier.padding(top=16.dp)) {
            Text(text = "Categories", style = MaterialTheme.typography.titleLarge,modifier = Modifier.padding(top =4.dp).padding(start = 7.dp))
            TextButton(onClick = { /*TODO*/ }, modifier = Modifier
                .padding(start = 170.dp)
                .fillMaxWidth()) {
                Text(text = "see all")
            }
        }
        Row(modifier = Modifier,horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedButton(onClick = { /*TODO*/ },
                enabled = true,
                colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta )
                ) {
                Text(text = "Healthy")
            }
            OutlinedButton(onClick = { /*TODO*/ }) {
                Text(text = "Healthy")
            }
        }
        Row(modifier = Modifier.padding(top=16.dp), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = null,Modifier.width(100.dp))
            Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = null,Modifier.width(100.dp))

        }
        Row(modifier = Modifier.padding(top=16.dp)) {
            Text(text = "Verified Chefs", style = MaterialTheme.typography.titleLarge,modifier = Modifier
                .padding(top = 4.dp)
                .padding(start = 7.dp))
            TextButton(onClick = { /*TODO*/ }, modifier = Modifier
                .padding(start = 132.dp)
                .fillMaxWidth()) {
                Text(text = "see all")
            }
        }
        Row(modifier = Modifier.padding(top=16.dp), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = null,Modifier.width(100.dp))
            Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = null,Modifier.width(100.dp))

        }
    }
}