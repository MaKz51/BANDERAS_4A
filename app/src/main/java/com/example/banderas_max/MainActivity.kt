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
                    BanderaNepalConstraint(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun LienzoNepal() {
    Canvas(modifier = Modifier.width(240.dp).height(290.dp)) {
        val mid = size.height / 2f

        drawPath(Path().apply {
            moveTo(0f, 0f); lineTo(size.width * 0.92f, size.height * 0.40f); lineTo(size.width * 0.25f, size.height * 0.40f)
            lineTo(size.width * 0.92f, size.height * 0.85f); lineTo(0f, size.height); close()
        }, color = Color(0xFF003893))

        drawPath(Path().apply {
            moveTo(size.width * 0.05f, size.height * 0.05f)
            lineTo(size.width * 0.80f, size.height * 0.38f); lineTo(size.width * 0.20f, size.height * 0.38f)
            lineTo(size.width * 0.80f, size.height * 0.82f); lineTo(size.width * 0.05f, size.height * 0.95f); close()
        }, color = Color(0xFFDC143C))

        drawCircle(Color.White, radius = size.height * 0.06f, center = Offset(size.width * 0.25f, size.height * 0.25f))
        drawCircle(Color.White, radius = size.height * 0.08f, center = Offset(size.width * 0.25f, size.height * 0.65f))
    }
}

@Composable fun BanderaNepalConstraint(modifier: Modifier = Modifier) = ConstraintLayout(modifier) {
    val (l) = createRefs(); Box(Modifier.constrainAs(l){ centerTo(parent) }) { LienzoNepal() }
}
@Preview(showBackground = true)
@Composable
fun VistaPreviaBandera() {
    BANDERAS_MAXTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            BanderaNepalConstraint()
        }
    }
}