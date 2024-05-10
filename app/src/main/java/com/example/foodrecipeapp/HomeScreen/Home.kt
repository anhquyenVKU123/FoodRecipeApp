@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.foodrecipeapp.HomeScreen

import GUI_NewRecipe
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.foodrecipeapp.HomeScreen.ui.theme.FoodRecipeAppTheme
import com.example.foodrecipeapp.R
import com.example.foodrecipeapp.StartScreen

class Home : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodRecipeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun GUI_Home(onButtonClick: () -> Unit) {
    val ScrollState = rememberScrollState()
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .verticalScroll(ScrollState)
        ){
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                val (frameA, frameB, frameC, frameD, frameE, frameRecipe, textRecipe, frameNewRecipe, frameBar) = createRefs()

                // Khung hình chữ nhật Xin chào
                Column(
                    modifier = Modifier
                        .size(195.dp, 52.dp)
                        .constrainAs(frameA) {
                            top.linkTo(parent.top, margin = 20.dp)
                            start.linkTo(parent.start, margin = 30.dp)
                            end.linkTo(parent.end, margin = 150.dp)
                        }
                ) {
                    Text("Hello Anh Quyen")
                    Text("What do you cook today?", modifier = Modifier.padding(top = 8.dp))
                }
                // Khung hình vuông avatar
                val avatar: Painter = painterResource(R.drawable.avatar_1)
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .constrainAs(frameB) {
                            top.linkTo(parent.top, margin = 26.dp)
                            start.linkTo(frameA.start, margin = 250.dp)
                            end.linkTo(parent.end, margin = 30.dp)
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = avatar,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillBounds
                    )
                }
                // Khung hình chữ nhật ô tìm kiếm
                Box(
                    modifier = Modifier
                        .constrainAs(frameC) {
                            top.linkTo(frameA.bottom, margin = 30.dp)
                            start.linkTo(parent.start, margin = 30.dp)
                            end.linkTo(parent.end, margin = 90.dp)
                        }
                        .border(
                            BorderStroke(1.dp, Color.Gray),
                            MaterialTheme.shapes.medium
                        )
                ) {
                    Row(
                        modifier = Modifier
                            .size(250.dp,49.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        var searchText by remember { mutableStateOf("") }
                        OutlinedTextField(
                            value = searchText,
                            onValueChange = { searchText = it },
                            modifier = Modifier
                                .weight(1f)
                                .height(49.dp)
                                .clip(RoundedCornerShape(percent = 30))
                                .background(Color.Transparent),
                            textStyle = TextStyle(
                                color = Color.Black,
                                fontSize = 16.sp,
                                lineHeight = 20.sp
                            ),
                            placeholder = { Text("Search") },
                            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search") },
                            trailingIcon = {
                                if (searchText.isNotEmpty()) {
                                    IconButton(onClick = { searchText = "" }) {
                                        Icon(Icons.Default.Close, contentDescription = null)
                                    }
                                }
                            },
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color.Transparent,
                                unfocusedBorderColor = Color.Transparent,
                                errorBorderColor = Color.Transparent
                            )
                        )
                    }
                }
                //Khung Frame ô lựa chọn tìm kiếm
                val filterImage: Painter = painterResource(R.drawable.setting_4)
                Box(
                    modifier = Modifier
                        .constrainAs(frameD) {
                            top.linkTo(parent.top, margin = 100.dp)
                            start.linkTo(parent.start, margin = 305.dp)
                            end.linkTo(parent.end, margin = 30.dp)
                            width = Dimension.wrapContent
                            height = Dimension.wrapContent
                        }
                        .size(49.dp)
                ) {
                    Button(
                        onClick = {},
                        Modifier.fillMaxSize(),
                        colors = ButtonDefaults.buttonColors(
                            Color(18,149,117)
                        ),
                        shape = RoundedCornerShape(percent = 30)
                    ){
                        Icon(
                            painter = filterImage,
                            contentDescription = null,
                            Modifier.graphicsLayer (scaleX = 20.0f, scaleY = 20.0f)
                        )
                    }
                }
                //Khung Frame chứa các button
                Box(
                    modifier = Modifier
                        .constrainAs(frameE) {
                            top.linkTo(frameC.bottom, margin = 15.dp)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                        .height(40.dp)
                        .horizontalScroll(rememberScrollState())
                ) {
                    Row(
                        Modifier.fillMaxSize()
                    ) {
                        Button(
                            onClick = { /* Xử lý sự kiện khi nhấn nút */ },
                            modifier = Modifier
                                .padding(start = 10.dp)
                                .height(40.dp)
                                .border(1.dp, Color(18,149,117), shape = RoundedCornerShape(percent = 30)),
                            colors = ButtonDefaults.buttonColors(Color.White),
                        ) {
                            Text(
                                text = "All",
                                color = Color(18,149,117),
                                fontWeight = FontWeight.Bold
                            )
                        }
                        val buttonStates = remember { mutableStateMapOf<Int, Boolean>() }
                        for (i in 1..7){
                            val buttonState = buttonStates[i] ?: false
                            Button(
                                onClick = {
                                    buttonStates.entries.forEach { entry -> buttonStates[entry.key] = false }
                                    buttonStates[i] = true
                                },
                                modifier = Modifier
                                    .padding(start = 15.dp)
                                    .height(40.dp)
                                    .border(
                                        1.dp,
                                        if (buttonState) Color(18,149,117) else Color.Transparent,
                                        shape = RoundedCornerShape(percent = 30)
                                    ),
                                colors = ButtonDefaults.buttonColors(
                                    if (buttonState) Color.White else Color(18,149,117)
                                )
                            ) {
                                Text(
                                    text = "Choose" + i,
                                    color = if (buttonState) Color(18,149,117) else Color.White,
                                    )
                            }
                        }
                    }
                }

                //Khung hiện danh sách công thức
                Box (
                    modifier = Modifier
                        .size(375.dp, 250.dp)
                        .background(Color.Transparent)
                        .constrainAs(frameRecipe) {
                            top.linkTo(frameE.bottom, margin = 15.dp)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                        .horizontalScroll(rememberScrollState())
                ){
                    Row(
                        Modifier
                            .fillMaxSize()
                            .padding(start = 10.dp)
                    ) {
                        for (i in 1..5){
                            GUI_AvatarDish()
                            Spacer(modifier = Modifier.size(10.dp))
                        }
                    }
                }

                //New Recipe
                Box (
                    modifier = Modifier
                        .size(140.dp, 30.dp)
                        .constrainAs(textRecipe) {
                            top.linkTo(frameRecipe.bottom, margin = 10.dp)
                            start.linkTo(parent.start, margin = 20.dp)
                        }
                ){
                    Text(
                        text = "New Recipe",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.fillMaxSize()
                    )
                }

                //Khung Frame NewRecipe
                Box (
                    modifier = Modifier
                        .size(375.dp, 150.dp)
                        .constrainAs(frameNewRecipe) {
                            top.linkTo(textRecipe.bottom, margin = 15.dp)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                        .horizontalScroll(rememberScrollState()),
                    contentAlignment = Alignment.TopCenter
                ){
                    Row(
                        Modifier
                            .fillMaxSize(1f)
                            .padding(start = 10.dp),
                        verticalAlignment = Alignment.Top
                    ) {
                        for (i in 1..5){
                            GUI_NewRecipe()
                            Spacer(modifier = Modifier.size(5.dp))
                        }
                    }
                }

                //Khung Navigation Bar
                Card(
                    modifier = Modifier
                        .size(300.dp, 50.dp)
                        .clip(shape = RoundedCornerShape(percent = 60))
                        .constrainAs(frameBar) {
                            top.linkTo(frameNewRecipe.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                ){
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .background(Color.White)
                            .border(
                                BorderStroke(2.dp, Color(18, 149, 117)),
                                MaterialTheme.shapes.medium
                            )
                    ){
                        GUI_NavigationBar()
                    }
                }
            }
        }
    }
}


@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Home") {
        composable("Home") { GUI_Home(onButtonClick = { navController.navigate("StartScreen") }) }
        composable("StartScreen") { StartScreen(onButtonClick = {navController.navigate("Home")}) }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    FoodRecipeAppTheme {
        MyApp()
    }
}