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
import androidx.compose.ui.unit.dp

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
                    BanderaKiribatiConstraint(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
@Composable
fun LienzoKiribati() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        drawRect(color = Color(0xFFCE1126), size = Size(size.width, size.height / 2f))

        val alturaFranja = (size.height / 2f) / 6f
        for (i in 0 until 6) {
            val colorFranja = if (i % 2 == 0) Color.White else Color(0xFF003F87)
            drawRect(
                color = colorFranja,
                topLeft = Offset(0f, (size.height / 2f) + (i * alturaFranja)),
                size = Size(size.width, alturaFranja)
            )
        }

        val cx = size.width / 2f
        val cy = size.height / 2f
        val radioSol = size.height * 0.18f

        drawArc(
            color = Color(0xFFFFCE00),
            startAngle = 180f,
            sweepAngle = 180f,
            useCenter = true,
            topLeft = Offset(cx - radioSol, cy - radioSol),
            size = Size(radioSol * 2, radioSol * 2)
        )

        val avePath = Path().apply {
            moveTo(cx, size.height * 0.16f) // Pico central arriba
            lineTo(size.width * 0.65f, size.height * 0.25f) // Punta ala derecha
            lineTo(cx + size.width * 0.03f, size.height * 0.20f) // Grosor interno derecho
            lineTo(cx, size.height * 0.21f) // Pico central abajo
            lineTo(cx - size.width * 0.03f, size.height * 0.20f) // Grosor interno izquierdo
            lineTo(size.width * 0.35f, size.height * 0.25f) // Punta ala izquierda
            close()
        }
        drawPath(avePath, color = Color(0xFFFFCE00))
    }
}

@Composable fun BanderaKiribatiConstraint(modifier: Modifier = Modifier) = ConstraintLayout(modifier) {
    val (l) = createRefs(); Box(Modifier.constrainAs(l){ centerTo(parent) }) { LienzoKiribati() }
}
@Preview(showBackground = true)
@Composable
fun VistaPreviaBandera() {
    BANDERAS_MAXTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            BanderaKiribatiConstraint()
        }
    }
}