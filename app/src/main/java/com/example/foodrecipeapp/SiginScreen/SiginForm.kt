package com.example.foodrecipeapp.SiginScreen

import android.graphics.drawable.Icon
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
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
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
import com.example.foodrecipeapp.LoginScreen.GUI_Login
import com.example.foodrecipeapp.R
import com.example.foodrecipeapp.SiginScreen.ui.theme.FoodRecipeAppTheme

class SiginForm : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodRecipeAppTheme {
                    GUI_Register(navController = rememberNavController())
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GUI_Register(navController : NavHostController) {
    val backgroundPainter: Painter = painterResource(R.drawable.image_1)
    Box(
        modifier = Modifier.fillMaxSize(),
    ){
        Image(
            painter = backgroundPainter,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Text(
            text = "REGISTER",
            color = Color.White,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 30.dp),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var fullname by remember{ mutableStateOf("")}
            TextField(
                value = fullname,
                onValueChange = {fullname = it},
                label = { Text(text = "Full Name")},
                placeholder = { Text(text = "Enter your Full Name")},
                leadingIcon = {Icon(Icons.Filled.Person, contentDescription = "Person Icon")},
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            var birthday by remember{ mutableStateOf("")}
            TextField(
                value = birthday,
                onValueChange = {birthday = it},
                label = { Text(text = "Birthday")},
                placeholder = { Text(text = "Enter your Birthday")},
                leadingIcon = {Icon(Icons.Filled.DateRange, contentDescription = "Date Icon")},
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            var phone by remember{ mutableStateOf("")}
            TextField(
                value = phone,
                onValueChange = {phone = it},
                label = { Text(text = "Phone Number")},
                placeholder = { Text(text = "Enter your phone number")},
                leadingIcon = {Icon(Icons.Filled.Call, contentDescription = "Phone Icon")},
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            var email by remember{ mutableStateOf("")}
            TextField(
                value = email,
                onValueChange = {email = it},
                label = { Text(text = "Email")},
                placeholder = { Text(text = "Enter your Email")},
                leadingIcon = {Icon(Icons.Filled.Email, contentDescription = "Email Icon")},
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            var username by remember{ mutableStateOf("")}
            TextField(
                value = username,
                onValueChange = {username = it},
                label = { Text(text = "Username")},
                placeholder = { Text(text = "Enter your username")},
                leadingIcon = {Icon(Icons.Filled.AccountCircle, contentDescription = "Username Icon")},
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            var password by remember{ mutableStateOf("")}
            TextField(
                value = password,
                onValueChange = {password = it},
                label = { Text(text = "Password")},
                placeholder = { Text(text = "Enter your password")},
                leadingIcon = {Icon(Icons.Filled.Lock, contentDescription = "Password Icon")},
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
            Button(
                onClick = { /*TODO*/ },
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
fun GreetingPreview6() {
    FoodRecipeAppTheme {
        GUI_Register(navController = rememberNavController())
    }
}