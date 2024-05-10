
import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Card
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.foodrecipeapp.HomeScreen.ui.theme.FoodRecipeAppTheme
import com.example.foodrecipeapp.R
import com.google.firebase.perf.util.Timer

class NewRecipe : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodRecipeAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GUI_NewRecipe()
                }
            }
        }
    }
}

@Composable
fun GUI_NewRecipe() {
    Box(
        modifier = Modifier
            .size(251.dp,127.dp)
    ){
        ConstraintLayout(
            modifier = Modifier.fillMaxSize(1f)
        ) {
            val (frameInfor, frameImage) = createRefs()

            //Khung chứa thông tin món ăn
            Card(
                modifier = Modifier
                    .background(Color.Transparent)
                    .size(235.dp, 95.dp)
                    .shadow(
                        elevation = 6.dp,
                        shape = RoundedCornerShape(percent = 10),
                        clip = true
                    )
                    .constrainAs(frameInfor) {
                        start.linkTo(parent.start, margin = 2.dp)
                        end.linkTo(parent.end, margin = 7.dp)
                        bottom.linkTo(parent.bottom, margin = 5.dp)
                    }
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                ){
                    ConstraintLayout(
                        Modifier.fillMaxSize()
                    ) {
                        val (frameText, frameAvatar, frameTime, frameTextName, frameButton) = createRefs()
                        //Têns món ăn
                        Box(
                            modifier = Modifier
                                .background(Color.Transparent)
                                .size(120.dp, 20.dp)
                                .constrainAs(frameText) {
                                    start.linkTo(parent.start, margin = 10.dp)
                                    top.linkTo(parent.top, margin = 10.dp)
                                }
                        ) {
                            Text(
                                text = "Đùi ếch xào xả ớt cực cháy",
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(start = 5.dp)
                            )
                        }

                        //Avatar Person
                        val avatar_person: Painter = painterResource(R.drawable.postperson_avatar1)
                        Box(
                            modifier = Modifier
                                .size(20.dp)
                                .background(Color.Transparent)
                                .constrainAs(frameAvatar) {
                                    start.linkTo(parent.start, margin = 10.dp)
                                    top.linkTo(frameText.bottom, margin = 5.dp)
                                }
                        ) {
                            Image(
                                painter = avatar_person,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(20.dp),
                                contentScale = ContentScale.FillBounds
                            )
                        }

                        //Tên ngườin đăng
                        Box(
                            modifier = Modifier
                                .constrainAs(frameTextName) {
                                    start.linkTo(frameAvatar.end, margin = 5.dp)
                                    top.linkTo(frameAvatar.top)
                                }
                        ) {
                            Text(
                                text = "Nguyen Viet Anh Quyen",
                                fontStyle = FontStyle.Italic,
                                fontSize = 10.sp
                            )
                        }

                        //Thời gian
                        val timeimage: Painter = painterResource(R.drawable.timer_1)
                        Row(
                            modifier = Modifier
                                .size(100.dp, 20.dp)
                                .constrainAs(frameTime) {
                                    start.linkTo(parent.start, margin = 170.dp)
                                    bottom.linkTo(parent.bottom, margin = 5.dp)
                                }
                        ) {
                            Image(
                                painter = timeimage,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(18.dp)
                                    .graphicsLayer(scaleX = 0.7f, scaleY = 0.7f),
                                contentScale = ContentScale.FillBounds
                            )
                            Text(
                                text = "15 phút",
                                fontStyle = FontStyle.Italic,
                                fontSize = 10.sp,
                                color = Color.Gray
                            )
                        }

                        //Button
                        Row (
                            modifier = Modifier
                                .size(150.dp, 30.dp)
                                .constrainAs(frameButton) {
                                    start.linkTo(parent.start, margin = 10.dp)
                                    bottom.linkTo(parent.bottom, margin = 5.dp)
                                },
                            verticalAlignment = Alignment.CenterVertically
                        ){

                            Box(
                                modifier = Modifier
                                    .size(80.dp, 20.dp)
                                    .clip(shape = RoundedCornerShape(percent = 30))
                            ){
                                IconButton(
                                    onClick = { /*TODO*/ },
                                    modifier = Modifier
                                        .background(Color(18,149,117))
                                        .fillMaxSize()
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically
                                    ){
                                        Text(
                                            text = "Chế biến",
                                            fontSize = 10.sp,
                                            color = Color.White,
                                            fontWeight = FontWeight.Bold,
                                            modifier = Modifier.padding(start = 5.dp)
                                        )
                                        Icon(
                                            Icons.Filled.ArrowForward,
                                            contentDescription = null,
                                            modifier = Modifier
                                                .size(20.dp)
                                                .padding(start = 5.dp),
                                            tint = Color.White
                                        )
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.size(30.dp))
                            Box(
                                contentAlignment = Alignment.Center
                            ){
                                IconButton(
                                    onClick = { /*TODO*/ },
                                    modifier = Modifier
                                        .background(Color.White)
                                    ) {
                                    Icon(
                                        Icons.Filled.Favorite,
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(20.dp)
                                            .padding(start = 5.dp),
                                        tint = Color.Red
                                    )
                                }
                            }
                        }
                    }
                }
            }

            //Khung chuaws hình ảnh món ăn
            val avatar_dish2: Painter = painterResource(R.drawable.dish_2)
            Box(
                modifier = Modifier
                    .size(80.dp, 86.dp)
                    .background(Color.Transparent)
                    .constrainAs(frameImage) {
                        start.linkTo(parent.start, margin = 150.76.dp)
                        bottom.linkTo(parent.bottom, margin = 40.dp)
                    }
            ){
                Image(
                    painter = avatar_dish2,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 10.dp)
                        .graphicsLayer(scaleX = 1.2f, scaleY = 1.2f),
                    contentScale = ContentScale.FillBounds
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    FoodRecipeAppTheme {
        GUI_NewRecipe()
    }
}