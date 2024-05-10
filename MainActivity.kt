@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.thigiuaki

import android.graphics.Paint.Align
import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thigiuaki.Home.Screen_Signin
import com.example.thigiuaki.ui.theme.ThigiuakiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThigiuakiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Screen_Signin()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun layout(){
    Scaffold(topBar = { topbar1() }, containerColor = Color.White) { padding->
        Column(modifier = Modifier
            .padding(padding)
            .padding(horizontal = 16.dp)) {
            anh_minh_hoa()
            profile()
            Row {
                Button(onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(Color(0,150,136)),
                    modifier = Modifier.width(180.dp)
                ) {
                    Text(text = "Ingidient")
                }
                Button(onClick = { /*TODO*/ },
                    enabled = false,
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        Color(0,150,136),
                        disabledContainerColor = Color.White,
                        disabledContentColor = Color(0,150,136)
                    ),
                    modifier = Modifier.width(180.dp)
                ) {
                    Text(text = "Procedure")
                }
            }
            Row(
                Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()) {
                Row(Modifier.alpha(0.3f)) {
                    Image(painter = painterResource(id = R.drawable.serve), contentDescription = null,Modifier.size(20.dp) )
                    Text(text = "1 serve")
                }
                Text(text = "10 items",
                    Modifier
                        .alpha(0.3f)
                        .padding(start = 240.dp))
            }
            Column {
                ingrdient(img = R.drawable.ic_launcher_background, name = "Tomatos", kg = "500g")
            }
        }

    }
}
@Composable
fun topbar1(){
    Column(modifier = Modifier.padding(end = 16.dp)) {
        CenterAlignedTopAppBar(
            title = { },
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Image(imageVector = Icons.Default.ArrowBack,
                        contentDescription = null)
                }
            },
            actions ={
                IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(30.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.option),
                        contentDescription = null)
                }
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(Color.White)
        )

    }

}
//@Preview(showBackground = true)
@Composable
fun anh_minh_hoa(){

    Box(modifier= Modifier
        .fillMaxWidth()){
        Image(painter = painterResource(id = R.drawable.spicychicken),
            contentDescription = null,
            modifier= Modifier
                .size(width = 1000.dp, height = 200.dp)
                .clip(RoundedCornerShape(20.dp)))

        Column(modifier = Modifier.padding(start=275.dp,top=10.dp) ){
            Button(modifier = Modifier.size(70.dp,32.dp),
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color(248, 235, 114, 255)),
                contentPadding = ButtonDefaults.TextButtonWithIconContentPadding
            ) {
                Image(painter = painterResource(id = R.drawable.baseline_star_24), contentDescription =null,modifier= Modifier.padding(start = 2.dp,top = 2.dp, bottom = 2.dp))
                Text(text = "4.0", color = Color.Black, modifier = Modifier.size(width = 30.dp, height = 20.dp))
            }
        }
    }
    Spacer(modifier = Modifier.padding(top = 16.dp))
    Row(horizontalArrangement = Arrangement.spacedBy(20.dp), modifier = Modifier
        .fillMaxWidth()
        .size(50.dp)) {

           Box {
               Text(text = "Spicy chicken burger with French fries  ",
                   fontWeight = FontWeight(weight = 1000),
                   style = MaterialTheme.typography.titleMedium,
                   modifier = Modifier.size(height = 50.dp, width = 220.dp))
           }


            Text(text = "(13k Reviews)",
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(width = 20.dp, height = 30.dp)
                    .alpha(0.3f))

    }
}

@Composable
fun profile(){
    Row(modifier = Modifier.padding(top=16.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
            Icon(imageVector = Icons.Default.AccountCircle, contentDescription =null, modifier = Modifier.size(40.dp))
            Column {
                Text(text = "Binh An",fontWeight = FontWeight(weight = 1000),
                    style = MaterialTheme.typography.titleMedium)
                Row {
                    Image(painter = painterResource(id = R.drawable.baseline_location_on_24), contentDescription = null)
                    Text(text = "Tam ky, Quang Nam", modifier = Modifier.alpha(0.3f))
                }
            }
        }
        Button(onClick = { /*TODO*/ },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(Color(0,150,136)),
            modifier = Modifier.padding(start = 75.dp)
        ) {
            Text(text = "Follow")
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun ingrdient(img:Int,name:String,kg:String){
    Box(
        Modifier
            .background(Color.LightGray, RoundedCornerShape(8.dp))
            .fillMaxWidth()) {
        Row(Modifier.fillMaxWidth()) {
            Image(painter = painterResource(id = img), contentDescription =null,
                Modifier
                    .size(70.dp)
                    .padding(16.dp) )
            Text(text = name,Modifier.padding(20.dp),
                fontWeight = FontWeight(weight = 1000),
                style = MaterialTheme.typography.titleMedium,)
            Text(text = kg,
                Modifier
                    .padding(top = 20.dp, bottom = 20.dp, start = 100.dp)
                    .alpha(0.3f),
                fontWeight = FontWeight(weight = 1000),
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Right
                )
        }
    }
}

