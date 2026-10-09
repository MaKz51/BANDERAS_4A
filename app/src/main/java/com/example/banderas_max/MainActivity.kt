package com.example.banderas_max

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
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

fun Path.addStar(center: Offset, radiusOut: Float, radiusIn: Float, points: Int = 5) {
    val angleStep = Math.PI / points
    var currentAngle = -Math.PI / 2.0
    moveTo(center.x + (radiusOut * cos(currentAngle)).toFloat(), center.y + (radiusOut * sin(currentAngle)).toFloat())
    for (i in 0 until points * 2) {
        val r = if (i % 2 == 0) radiusOut else radiusIn
        lineTo(center.x + (r * cos(currentAngle)).toFloat(), center.y + (r * sin(currentAngle)).toFloat())
        currentAngle += angleStep
    }
    close()
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BANDERAS_MAXTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BanderaSudafrica(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun LienzoSudafrica() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        drawRect(color = Color(0xFF001489), size = Size(size.width, size.height / 2f))
        drawRect(color = Color(0xFFFFB612), topLeft = Offset(0f, size.height / 2f), size = Size(size.width, size.height / 2f))

        val apex = Offset(size.width * 0.36f, size.height / 2f)
        val wWhite = size.height * 0.30f
        val wGreen = size.height * 0.20f

        fun drawPall(color: Color, width: Float) {
            drawLine(color, Offset(0f, 0f), apex, width)
            drawLine(color, Offset(0f, size.height), apex, width)
            drawLine(color, apex, Offset(size.width, size.height / 2f), width)
        }

        drawPall(Color.White, wWhite)
        drawPall(Color(0xFF007749), wGreen)

        drawPath(Path().apply {
            moveTo(0f, size.height * 0.17f)
            lineTo(size.width * 0.26f, size.height / 2f)
            lineTo(0f, size.height * 0.83f)
            close()
        }, Color.Black)
    }
}

@Composable
fun BanderaSudafrica(modifier: Modifier = Modifier) = Box(modifier) { LienzoSudafrica() }

@Preview(showBackground = true)
@Composable
fun VistaPreviaBandera() {
    BANDERAS_MAXTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            BanderaSudafrica()
        }
    }
}