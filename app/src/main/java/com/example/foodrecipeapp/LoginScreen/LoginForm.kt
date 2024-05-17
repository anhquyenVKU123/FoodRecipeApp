@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package com.example.foodrecipeapp.LoginScreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.foodrecipeapp.HomeScreen.GUI_Home
import com.example.foodrecipeapp.LoginScreen.ui.theme.FoodRecipeAppTheme
import com.example.foodrecipeapp.R
import com.example.foodrecipeapp.SiginScreen.GUI_Register
import com.example.foodrecipeapp.StartScreen

class LoginForm : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodRecipeAppTheme {
                    GUI_Login(navController = rememberNavController())
            }
        }
    }
}

@Composable
fun GUI_Login(navController : NavHostController) {
    val background : Painter = painterResource(id = R.drawable.image_1)
    Box(
        modifier = Modifier.fillMaxSize(),
        ){
        Image(
            painter = background,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Text(
            text = "LOG IN",
            color = Color.White,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 96.dp),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            var username by remember{ mutableStateOf("") }
            TextField(
                value = username,
                onValueChange = {username = it},
                label = { Text(text = "Username")},
                placeholder = { Text(text = "Enter your username")},
                leadingIcon = { Icon(Icons.Filled.AccountCircle, contentDescription = "Username Icon") },
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            var password by remember{ mutableStateOf("") }
            TextField(
                value = password,
                onValueChange = {password = it},
                label = { Text(text = "Password")},
                placeholder = { Text(text = "Enter your password")},
                leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "Password Icon") },
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
            Button(
                onClick = {  },
                modifier = Modifier.padding(top = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    Color(18,149,117)
                )
            ){
                Text(text = "Log in")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "If you don't have an account, please register",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Button(
                onClick = { navController.navigate("Register") },
                modifier = Modifier.padding(top = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    Color(18,149,117)
                )
            ){
                Text(text = "Register")
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview7() {
    FoodRecipeAppTheme {
        GUI_Login(navController = rememberNavController())
    }
}