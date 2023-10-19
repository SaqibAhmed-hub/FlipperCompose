package com.example.flipperanimationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.flipperanimationcompose.component.CardFace
import com.example.flipperanimationcompose.component.FlipperCard
import com.example.flipperanimationcompose.ui.theme.FlipperAnimationComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlipperAnimationComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    var cardFace by remember {
                        mutableStateOf(CardFace.Front)
                    }
                    FlipperCard(
                        cardFace = cardFace,
                        onClick = {
                            cardFace = cardFace.next
                        },
                        modifier = Modifier
                            .fillMaxWidth(.5f)
                            .aspectRatio(1f),
                        front = {
                            FrontView()
                        },
                        back = {
                            BackView()
                        }

                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        color = Color.White
    )
}

@Composable
fun FrontView(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
            .padding(16.dp),
        contentAlignment = Alignment.Center,
    ) {
        Column {
            Text(
                text = "Front",
                style = MaterialTheme.typography.h3,
                color = Color.White
            )
            Greeting(name = "World")
        }
    }
}

@Composable
fun BackView(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
            .padding(16.dp),
        contentAlignment = Alignment.Center,
    ) {
        Column {
            Text(
                text = "Back",
                style = MaterialTheme.typography.h3,
                color = Color.White
            )
            Greeting(name = "Android")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FlipperAnimationComposeTheme {
        Greeting("Android")
    }
}