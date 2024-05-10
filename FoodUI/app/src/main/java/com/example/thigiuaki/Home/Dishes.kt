package com.example.thigiuaki.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thigiuaki.R
import com.google.firebase.Firebase
import com.google.firebase.database.database


@Composable
fun Screen_Signin(){

    val database = Firebase.database
    val myRef = database.getReference("Message")
    myRef.setValue("abc")
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp)) {
        TextField(value = "", onValueChange ={}, label = { Text(text = "Username")})
        TextField(value = "", onValueChange ={}, label = { Text(text = "Password")})
        Button(onClick = {
            val accountInfo = AccountInfo("abc","123")
            myRef.child("Account1 ").setValue(accountInfo).addOnSuccessListener {

            }.addOnFailureListener{

            }
        }) {

        }
    }
}