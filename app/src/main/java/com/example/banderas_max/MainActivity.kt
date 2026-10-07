package com.example.banderas_max

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.banderas_max.ui.theme.BANDERAS_MAXTheme

//moldes geometricos utilizados en ciertas banderas
val TrianguloDerShape = GenericShape { size, _ ->
    moveTo(0f, 0f); lineTo(size.width, size.height / 2f); lineTo(0f, size.height); close()
}
val TrianguloArrShape = GenericShape { size, _ ->
    moveTo(size.width / 2f, 0f); lineTo(size.width, size.height); lineTo(0f, size.height); close()
}
val TrianguloAbaShape = GenericShape { size, _ ->
    moveTo(0f, 0f); lineTo(size.width, 0f); lineTo(size.width / 2f, size.height); close()
}
val DiagonalShape = GenericShape { size, _ ->
    moveTo(0f, size.height); lineTo(size.width, 0f); lineTo(size.width, size.height); close()
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