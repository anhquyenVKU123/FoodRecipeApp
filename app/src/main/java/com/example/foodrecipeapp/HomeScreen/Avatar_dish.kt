package com.example.foodrecipeapp.HomeScreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.foodrecipeapp.HomeScreen.ui.theme.FoodRecipeAppTheme
import com.example.foodrecipeapp.R

class Avatar_dish : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodRecipeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GUI_AvatarDish()
                }
            }
        }
    }
}

@Composable
fun GUI_AvatarDish() {
    Box (
        modifier = Modifier
            .size(150.dp,231.dp)
    ){
        ConstraintLayout(
            modifier = Modifier.fillMaxSize()
        ) {
            val (frameInfor, avatar) = createRefs()
            //Khung thông tin mons ăn
            Card(
                modifier = Modifier
                    .background(Color.Transparent)
                    .size(150.dp, 176.dp)
                    .clip(shape = RoundedCornerShape(percent = 10))
                    .constrainAs(frameInfor) {
                        bottom.linkTo(parent.bottom)
                    }
            ){
                Box (
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(169, 169, 169))
                ){
                    Text(
                        text = "Classic Greek Salad",
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(start = 10.dp, top = 66.dp, bottom = 68.dp, end = 10.dp)
                    )
                    ConstraintLayout {
                        val (item1, button) = createRefs()
                        Column(
                            modifier = Modifier
                                .size(60.dp, 49.dp)
                                .background(Color.Transparent)
                                .constrainAs(item1) {
                                    top.linkTo(parent.top, margin = 120.dp)
                                    start.linkTo(parent.start, margin = 10.dp)
                                }
                        ) {
                            Text(
                                text = "Time",
                                fontSize = 15.sp,
                            )
                            Text(
                                text = "32 days",
                                fontSize = 15.sp,
                                modifier = Modifier.fillMaxSize(),
                                color = Color.Black
                            )
                        }
                        Column(
                            modifier = Modifier
                                .background(Color.Transparent)
                                .size(60.dp, 70.dp)
                                .constrainAs(button) {
                                    start.linkTo(parent.start, margin = 100.dp)
                                    top.linkTo(parent.top, margin = 107.dp)
                                    end.linkTo(parent.end, margin = 20.dp)
                                },
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            IconButton(
                                onClick = { /*TODO*/ },
                                modifier = Modifier.size(30.dp),
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Favorite,
                                    contentDescription = null,
                                    tint = Color.White
                                )
                            }
                            IconButton(
                                onClick = { /*TODO*/ },
                                modifier = Modifier.size(30.dp),
                            ) {
                                Icon(
                                    imageVector = Icons.Default.PlayArrow,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(30.dp)
                                )
                            }
                        }
                    }
                }
            }

            //Khung chứa hình ảnh thức ăn
            val avatar_dish: Painter = painterResource(R.drawable.dish_1)
            Box(
                modifier = Modifier
                    .background(Color.Transparent)
                    .size(109.dp, 110.dp)
                    .constrainAs(avatar) {
                        top.linkTo(parent.top, margin = 20.dp)
                        start.linkTo(parent.start, margin = 22.dp)
                    }
            ){
                Image(
                    painter = avatar_dish,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .graphicsLayer(scaleX = 1.5f, scaleY = 1.3f),
                    contentScale = ContentScale.FillBounds
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    FoodRecipeAppTheme {
        GUI_AvatarDish()
    }
}