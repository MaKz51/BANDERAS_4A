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
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.banderas_max.ui.theme.BANDERAS_MAXTheme
import kotlin.math.cos
import kotlin.math.sin
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Surface
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BANDERAS_MAXTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PatoPixelArt(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun PatoPixelArt(modifier: Modifier = Modifier) {
    val p = 24.dp
    val negro = Color(0xFF1A1A1A)
    val naranja = Color(0xFFE46C38)

    Column(modifier = modifier.wrapContentSize()) {

        Row { Box(Modifier.size(width = p * 12, height = p)) }

        Row {
            Box(Modifier.size(width = p * 3, height = p))
            Box(Modifier.size(width = p * 3, height = p).background(negro))
            Box(Modifier.size(width = p * 6, height = p))
        }

        Row {
            Box(Modifier.size(width = p * 2, height = p))
            Box(Modifier.size(width = p * 1, height = p).background(negro))
            Box(Modifier.size(width = p * 3, height = p))
            Box(Modifier.size(width = p * 1, height = p).background(negro))
            Box(Modifier.size(width = p * 5, height = p))
        }

        Row {
            Box(Modifier.size(width = p * 1, height = p))
            Box(Modifier.size(width = p * 1, height = p).background(negro))
            Box(Modifier.size(width = p * 2, height = p).background(naranja))
            Box(Modifier.size(width = p * 1, height = p).background(negro))
            Box(Modifier.size(width = p * 1, height = p))
            Box(Modifier.size(width = p * 1, height = p).background(negro))
            Box(Modifier.size(width = p * 5, height = p))
        }

        Row {
            Box(Modifier.size(width = p * 2, height = p))
            Box(Modifier.size(width = p * 1, height = p).background(negro))
            Box(Modifier.size(width = p * 3, height = p))
            Box(Modifier.size(width = p * 1, height = p).background(negro))
            Box(Modifier.size(width = p * 5, height = p))
        }

        Row {
            Box(Modifier.size(width = p * 3, height = p))
            Box(Modifier.size(width = p * 1, height = p).background(negro))
            Box(Modifier.size(width = p * 2, height = p))
            Box(Modifier.size(width = p * 1, height = p).background(negro))
            Box(Modifier.size(width = p * 5, height = p))
        }
        Row {
            Box(Modifier.size(width = p * 3, height = p))
            Box(Modifier.size(width = p * 1, height = p).background(negro))
            Box(Modifier.size(width = p * 2, height = p))
            Box(Modifier.size(width = p * 1, height = p).background(negro))
            Box(Modifier.size(width = p * 5, height = p))
        }

        Row {
            Box(Modifier.size(width = p * 2, height = p))
            Box(Modifier.size(width = p * 1, height = p).background(negro))
            Box(Modifier.size(width = p * 3, height = p))
            Box(Modifier.size(width = p * 1, height = p).background(negro))
            Box(Modifier.size(width = p * 5, height = p))
        }

        Row {
            Box(Modifier.size(width = p * 2, height = p))
            Box(Modifier.size(width = p * 1, height = p).background(negro))
            Box(Modifier.size(width = p * 4, height = p))
            Box(Modifier.size(width = p * 2, height = p).background(negro))
            Box(Modifier.size(width = p * 3, height = p))
        }

        Row {
            Box(Modifier.size(width = p * 2, height = p))
            Box(Modifier.size(width = p * 1, height = p).background(negro))
            Box(Modifier.size(width = p * 6, height = p))
            Box(Modifier.size(width = p * 2, height = p).background(negro))
            Box(Modifier.size(width = p * 1, height = p))
        }

        Row {
            Box(Modifier.size(width = p * 2, height = p))
            Box(Modifier.size(width = p * 1, height = p).background(negro))
            Box(Modifier.size(width = p * 7, height = p))
            Box(Modifier.size(width = p * 1, height = p).background(negro))
            Box(Modifier.size(width = p * 1, height = p))
        }

        Row {
            Box(Modifier.size(width = p * 3, height = p))
            Box(Modifier.size(width = p * 1, height = p).background(negro))
            Box(Modifier.size(width = p * 5, height = p))
            Box(Modifier.size(width = p * 1, height = p).background(negro))
            Box(Modifier.size(width = p * 2, height = p))
        }

        Row {
            Box(Modifier.size(width = p * 4, height = p))
            Box(Modifier.size(width = p * 5, height = p).background(negro))
            Box(Modifier.size(width = p * 3, height = p))
        }

        Row {
            Box(Modifier.size(width = p * 3, height = p))
            Box(Modifier.size(width = p * 1, height = p).background(negro))
            Box(Modifier.size(width = p * 2, height = p).background(naranja)) // Pata izquierda ancha
            Box(Modifier.size(width = p * 1, height = p).background(negro))
            Box(Modifier.size(width = p * 1, height = p).background(naranja)) // Pata derecha delgada
            Box(Modifier.size(width = p * 1, height = p).background(negro))
            Box(Modifier.size(width = p * 3, height = p))
        }

        Row {
            Box(Modifier.size(width = p * 3, height = p))
            Box(Modifier.size(width = p * 6, height = p).background(negro))
            Box(Modifier.size(width = p * 3, height = p))
        }

        Row { Box(Modifier.size(width = p * 12, height = p)) }
    }
}
@Preview(showBackground = true)
@Composable
fun VistaPrevia() {
    BANDERAS_MAXTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            PatoPixelArt()
        }
    }
}