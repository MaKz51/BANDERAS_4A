package com.example.banderas_max

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.banderas_max.ui.theme.BANDERAS_MAXTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BANDERAS_MAXTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    BanderaItalia(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun BanderaJapon(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .background(Color.Red)
        )
    }
}

@Composable
fun BanderaFrancia(modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxSize()) {
        Box(Modifier.weight(1f).fillMaxHeight().background(Color(0xFF0055A4)))
        Box(Modifier.weight(1f).fillMaxHeight().background(Color.White))
        Box(Modifier.weight(1f).fillMaxHeight().background(Color(0xFFEF4135)))
    }
}

@Composable
fun BanderaItalia(modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxSize()) {
        Box(Modifier.weight(1f).fillMaxHeight().background(Color(0xFF009246)))
        Box(Modifier.weight(1f).fillMaxHeight().background(Color.White))
        Box(Modifier.weight(1f).fillMaxHeight().background(Color(0xFFCE2B37)))
    }
}

@Composable
fun BanderaAlemania(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        Box(Modifier.weight(1f).fillMaxWidth().background(Color.Black))
        Box(Modifier.weight(1f).fillMaxWidth().background(Color(0xFFDD0000)))
        Box(Modifier.weight(1f).fillMaxWidth().background(Color(0xFFFFCE00)))
    }
}

@Composable
fun BanderaEspana(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        Box(Modifier.weight(1f).fillMaxWidth().background(Color(0xFFAA151B)))
        Box(Modifier.weight(2f).fillMaxWidth().background(Color(0xFFF1BF00)))
        Box(Modifier.weight(1f).fillMaxWidth().background(Color(0xFFAA151B)))
    }
}