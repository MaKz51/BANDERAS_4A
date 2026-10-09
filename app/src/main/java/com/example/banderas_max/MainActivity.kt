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


// Utilidad trigonométrica para estrellas
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
                    BanderaSeychellesConstraint(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VistaPreviaBandera() {
    BANDERAS_MAXTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            BanderaSeychellesConstraint()
        }
    }
}

@Composable
fun LienzoSeychelles() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val colors = listOf(Color(0xFF003F87), Color(0xFFFCD116), Color(0xFFD92223), Color.White, Color(0xFF007A3D))
        val points = listOf(Offset(0f, 0f), Offset(size.width * 0.33f, 0f), Offset(size.width * 0.66f, 0f), Offset(size.width, 0f), Offset(size.width, size.height * 0.33f), Offset(size.width, size.height))
        for (i in 0 until 5) {
            val path = Path().apply {
                moveTo(0f, size.height); lineTo(points[i].x, points[i].y)
                if (i == 2) lineTo(points[i+1].x, points[i+1].y)
                lineTo(points[i+1].x, points[i+1].y); close()
            }
            drawPath(path, colors[i])
        }
    }
}
@Composable fun BanderaSeychellesConstraint(modifier: Modifier = Modifier) = ConstraintLayout(modifier) { val (l) = createRefs(); Box(Modifier.constrainAs(l){ centerTo(parent) }) { LienzoSeychelles() } }