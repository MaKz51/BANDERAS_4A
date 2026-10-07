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
                    BanderaCubaConstraint(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BanderaCubaConstraint(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier.fillMaxSize()) {
        val (franjas, triangulo, estrella) = createRefs()
        Column(Modifier.fillMaxSize().constrainAs(franjas) { centerTo(parent) }) {
            for (i in 0..4) Box(Modifier.weight(1f).fillMaxWidth().background(if (i % 2 == 0) Color(0xFF002E6E) else Color.White))
        }
        Box(Modifier.fillMaxHeight().clip(TrianguloDerShape).background(Color(0xFFCB1428)).constrainAs(triangulo) {
            start.linkTo(parent.start); width = Dimension.percent(0.45f)
        })
        Icon(Icons.Filled.Star, contentDescription = null, tint = Color.White, modifier = Modifier.size(50.dp).constrainAs(estrella) {
            start.linkTo(parent.start, margin = 30.dp); top.linkTo(parent.top); bottom.linkTo(parent.bottom)
        })
    }
}