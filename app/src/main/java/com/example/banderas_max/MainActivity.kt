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
            BanderaUK()
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
                    BanderaUK(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
@Composable
fun LienzoUK() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        drawRect(Color(0xFF012169))
        val thickW = size.height * 0.22f; val thinR = size.height * 0.08f
        drawLine(Color.White, Offset(0f, 0f), Offset(size.width, size.height), thickW)
        drawLine(Color.White, Offset(size.width, 0f), Offset(0f, size.height), thickW)
        drawLine(Color(0xFFC8102E), Offset(0f, thinR), Offset(size.width, size.height + thinR), thinR)
        drawLine(Color(0xFFC8102E), Offset(size.width, -thinR), Offset(0f, size.height - thinR), thinR)
        drawRect(Color.White, Offset(size.width/2 - thickW/2, 0f), Size(thickW, size.height))
        drawRect(Color.White, Offset(0f, size.height/2 - thickW/2), Size(size.width, thickW))
        drawRect(Color(0xFFC8102E), Offset(size.width/2 - thinR*1.5f, 0f), Size(thinR*3, size.height))
        drawRect(Color(0xFFC8102E), Offset(0f, size.height/2 - thinR*1.5f), Size(size.width, thinR*3))
    }
}
@Composable fun BanderaUK(modifier: Modifier = Modifier) = Box(modifier) { LienzoUK() }
