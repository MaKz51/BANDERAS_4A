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
                    BanderaIsraelConstraint(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BanderaIsraelConstraint(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier.fillMaxSize().background(Color.White)) {
        val (fTop, fBot, estrella1, estrella2) = createRefs()
        Box(Modifier.fillMaxWidth().background(Color(0xFF0038B8)).constrainAs(fTop) {
            top.linkTo(parent.top, margin = 30.dp); height = Dimension.percent(0.15f)
        })
        Box(Modifier.fillMaxWidth().background(Color(0xFF0038B8)).constrainAs(fBot) {
            bottom.linkTo(parent.bottom, margin = 30.dp); height = Dimension.percent(0.15f)
        })
        Box(Modifier.size(100.dp).border(8.dp, Color(0xFF0038B8), TrianguloArrShape).constrainAs(estrella1) { centerTo(parent) })
        Box(Modifier.size(100.dp).border(8.dp, Color(0xFF0038B8), TrianguloAbaShape).constrainAs(estrella2) { centerTo(parent) })
    }
}