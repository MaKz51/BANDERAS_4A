package com.example.banderas_max

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.banderas_max.ui.theme.BANDERAS_MAXTheme
import kotlin.math.cos
import kotlin.math.sin
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Surface
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale

@Preview(showBackground = true)
@Composable
fun VistaPreviaBandera() {
    BANDERAS_MAXTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            BanderaSeychelles()
        }
    }
}
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BANDERAS_MAXTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BanderaSeychelles(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}



@Composable
fun BanderaSeychelles(modifier: Modifier = Modifier) {
    Box(modifier.fillMaxSize().background(Color(0xFF007A3D)), contentAlignment = Alignment.BottomStart) {
        Box(Modifier.scale(2f).rotate(-15f).fillMaxSize().background(Color.White))
        Box(Modifier.scale(2f).rotate(-35f).fillMaxSize().background(Color(0xFFD92223)))
        Box(Modifier.scale(2f).rotate(-55f).fillMaxSize().background(Color(0xFFFCD116)))
        Box(Modifier.scale(2f).rotate(-75f).fillMaxSize().background(Color(0xFF003F87)))
    }
}