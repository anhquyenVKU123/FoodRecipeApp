package com.example.foodrecipeapp.HomeScreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodrecipeapp.HomeScreen.ui.theme.FoodRecipeAppTheme
import com.example.foodrecipeapp.R

class NavigationBar : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodRecipeAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GUI_NavigationBar()
                }
            }
        }
    }
}

@Composable
fun GUI_NavigationBar() {
    Row(
        modifier = Modifier
            .fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ){
        val hombar:Painter = painterResource(R.drawable.home_bar_1)
        val bookmark:Painter = painterResource(R.drawable.bookmark_bar_4)
        val notifbar:Painter = painterResource(R.drawable.notif_bar_3)
        val personbar:Painter = painterResource(R.drawable.profile_bar_2)
        IconButton(
            onClick = { /*TODO*/ }
        ) {
            Image(
                painter = hombar,
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp),
                contentScale = ContentScale.FillBounds,
            )
        }
        IconButton(
            onClick = { /*TODO*/ }
        ) {
            Image(
                painter = bookmark,
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp),
                contentScale = ContentScale.FillBounds,
            )
        }
        IconButton(
            onClick = { /*TODO*/ }
        ) {
            Image(
                painter = notifbar,
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp),
                contentScale = ContentScale.FillBounds,
            )
        }
        IconButton(
            onClick = { /*TODO*/ }
        ) {
            Image(
                painter = personbar,
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp),
                contentScale = ContentScale.FillBounds,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview5() {
    FoodRecipeAppTheme {
        GUI_NavigationBar()
    }
}