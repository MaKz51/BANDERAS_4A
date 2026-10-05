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
//italia

@Composable
fun BanderaItalia(modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxSize()) {
        Box(Modifier.weight(1f).fillMaxHeight().background(Color(0xFF009246)))
        Box(Modifier.weight(1f).fillMaxHeight().background(Color.White))
        Box(Modifier.weight(1f).fillMaxHeight().background(Color(0xFFCE2B37)))
    }
}
