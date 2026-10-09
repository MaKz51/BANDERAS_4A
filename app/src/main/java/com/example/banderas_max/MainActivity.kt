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

@Preview(showBackground = true)
@Composable
fun VistaPreviaBandera() {
    BANDERAS_MAXTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            BanderaPNGConstraint()
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
                    BanderaPNGConstraint(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun LienzoPNG() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        drawRect(Color.Black)
        drawPath(Path().apply { moveTo(0f, 0f); lineTo(size.width, 0f); lineTo(size.width, size.height); close() }, Color(0xFFCE1126))
        drawPath(Path().apply { addStar(Offset(size.width * 0.25f, size.height * 0.3f), 40f, 15f) }, Color.White)
        drawPath(Path().apply { addStar(Offset(size.width * 0.35f, size.height * 0.5f), 30f, 12f) }, Color.White)
        drawPath(Path().apply { addStar(Offset(size.width * 0.25f, size.height * 0.7f), 40f, 15f) }, Color.White)
        drawPath(Path().apply { addStar(Offset(size.width * 0.15f, size.height * 0.5f), 40f, 15f) }, Color.White)

        val ave = Path().apply { moveTo(size.width * 0.75f, size.height * 0.2f); lineTo(size.width * 0.85f, size.height * 0.4f); lineTo(size.width * 0.65f, size.height * 0.5f); close() }
        drawPath(ave, Color(0xFFFCD116))
    }
}
@Composable fun BanderaPNGConstraint(modifier: Modifier = Modifier) = ConstraintLayout(modifier) { val (l) = createRefs(); Box(Modifier.constrainAs(l){ centerTo(parent) }) { LienzoPNG() } }