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
import androidx.compose.ui.graphics.drawscope.Stroke

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
                    BanderaButanConstraint(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun LienzoButan() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        drawPath(Path().apply {
            moveTo(0f, 0f); lineTo(size.width, 0f); lineTo(0f, size.height); close()
        }, Color(0xFFFFD520))

        drawPath(Path().apply {
            moveTo(size.width, 0f); lineTo(size.width, size.height); lineTo(0f, size.height); close()
        }, Color(0xFFFF4E12))

        drawPath(Path().apply {
            moveTo(size.width * 0.3f, size.height * 0.7f)
            lineTo(size.width * 0.4f, size.height * 0.5f)
            lineTo(size.width * 0.5f, size.height * 0.6f)
            lineTo(size.width * 0.6f, size.height * 0.4f)
            lineTo(size.width * 0.7f, size.height * 0.5f)
            lineTo(size.width * 0.8f, size.height * 0.3f)
        }, color = Color.White, style = Stroke(width = 15f))
    }
}

@Composable fun BanderaButanConstraint(modifier: Modifier = Modifier) = ConstraintLayout(modifier) {
    val (l) = createRefs(); Box(Modifier.constrainAs(l){ centerTo(parent) }) { LienzoButan() }
}
@Preview(showBackground = true)
@Composable
fun VistaPreviaBandera() {
    BANDERAS_MAXTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            BanderaButanConstraint()
        }
    }
}