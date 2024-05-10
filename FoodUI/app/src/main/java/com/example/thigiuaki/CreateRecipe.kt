package com.example.thigiuaki

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true)
@Composable
fun Screen(){
    Column(modifier = Modifier
        .padding(horizontal = 16.dp)
        .fillMaxWidth()) {
        Text(text="Create Recipe", style =  MaterialTheme.typography.titleMedium, color = Color.Magenta, fontWeight = FontWeight(1000))
        OutlinedTextField(value = "", onValueChange = {}, placeholder = {Text(text = "Name your dish...",Modifier.alpha(0.3f))}, shape = RoundedCornerShape(20.dp), modifier = Modifier.fillMaxWidth())
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.padding(top=16.dp, start = 10.dp)) {
            Icon(imageVector = Icons.Default.AccountCircle, contentDescription =null )
            Text(text = "Serves", style = MaterialTheme.typography.titleLarge)
            Box {
                Row(modifier = Modifier.padding(start = 130.dp)) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null )
                    Text(text="3",
                        Modifier
                            .width(60.dp)
                            .height(25.dp)
                            .padding(top = 3.dp)
                            .background(
                                Color.LightGray
                            ), textAlign = TextAlign.Center)
                    Icon(imageVector = Icons.Default.Add, contentDescription = null )
                }
            }

        }
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier
            .padding(top = 16.dp, start = 10.dp)
            .fillMaxWidth()) {
            Icon(imageVector = Icons.Default.AccountCircle, contentDescription =null )
            Text(text = "Cook Time", style = MaterialTheme.typography.titleLarge)
            OutlinedTextField(value = "", onValueChange = {}, placeholder = {Text(text = "in mins",Modifier.alpha(0.3f))}, shape = RoundedCornerShape(20.dp), modifier = Modifier
                .width(220.dp)
                .height(50.dp)
                .padding(start = 90.dp))
        }
        Text(text="Ingredients", style =  MaterialTheme.typography.titleMedium, color = Color.Magenta, fontWeight = FontWeight(1000))
        Row {
            OutlinedTextField(value = "", onValueChange = {}, placeholder = {Text(text = "Item",Modifier.alpha(0.3f))}, shape = RoundedCornerShape(20.dp), modifier = Modifier
                .width(220.dp)
                .height(50.dp)
                .padding(start = 10.dp))
            OutlinedTextField(value = "", onValueChange = {}, placeholder = {Text(text = "Quanlity",Modifier.alpha(0.3f))}, shape = RoundedCornerShape(20.dp), modifier = Modifier
                .width(220.dp)
                .height(50.dp)
                .padding(start = 20.dp))
        }
        Row(modifier = Modifier.padding(top=10.dp).alpha(0.6f)) {
            Icon(imageVector = Icons.Default.Add, contentDescription = null)
            Text(text = "Add more ingredients", modifier = Modifier.padding(top = 3.dp))
        }
        Text(text="Precedure", style =  MaterialTheme.typography.titleMedium, color = Color.Magenta, fontWeight = FontWeight(1000))
        OutlinedTextField(value = "", onValueChange = {}, placeholder = {Text(text = "...",Modifier.alpha(0.3f))}, shape = RoundedCornerShape(20.dp), modifier = Modifier.fillMaxWidth())
    }
}