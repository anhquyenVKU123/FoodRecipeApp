package com.example.foodrecipeapp

import android.opengl.GLES11Ext
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodrecipeapp.ui.theme.FoodRecipeAppTheme
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.foodrecipeapp.HomeScreen.GUI_Home
import com.example.foodrecipeapp.HomeScreen.Home


class MainActivity : ComponentActivity() {
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
fun StartScreen(onButtonClick: () -> Unit) {
    val backgroundPainter: Painter = painterResource(R.drawable.image_1)
    val image_2 : Painter = painterResource(R.drawable.image_2)
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = backgroundPainter,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentSize()
            ) {
                Image(
                    painter = image_2,
                    contentDescription = null,
                    modifier = Modifier.size(150.dp),
                    contentScale = ContentScale.Fit
                )
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentSize()
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Get Cooking",
                        style = TextStyle(fontSize = 32.sp),
                        color = Color.White
                    )
                    Text(
                        text = "Simple way to find Tasty Recipe",
                        style = TextStyle(fontSize = 10.sp),
                        color = Color.White
                    )
                }
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .wrapContentSize()
            ) {
                Button(
                    onClick = onButtonClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp),
                    colors = ButtonDefaults.buttonColors(
                        Color(18,149,117)
                    )
                ){
                    Text(
                        text = "Start Cooking",
                        style = TextStyle(fontSize = 24.sp)
                    )
                }
            }
        }
    }
}
@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "StartScreen") {
        composable("StartScreen") { StartScreen(onButtonClick = { navController.navigate("Home") }) }
        composable("Home") { GUI_Home(onButtonClick = { navController.navigate("StartScreen") })}

    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FoodRecipeAppTheme {
        MyApp()
    }
}
//Anh Quyền đã update code