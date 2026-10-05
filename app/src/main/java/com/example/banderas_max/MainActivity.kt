package com.example.banderas_max

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.banderas_max.ui.theme.BANDERAS_MAXTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BANDERAS_MAXTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BanderaColombiaConstraint(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BanderaColombiaConstraint(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (amarillo, azul, rojo) = createRefs()
        val gMedio = createGuidelineFromTop(0.50f)
        val gInferior = createGuidelineFromTop(0.75f)
        Box(Modifier.fillMaxWidth().background(Color(0xFFFFCD00)).constrainAs(amarillo) {
            top.linkTo(parent.top); bottom.linkTo(gMedio); height = Dimension.fillToConstraints
        })
        Box(Modifier.fillMaxWidth().background(Color(0xFF003087)).constrainAs(azul) {
            top.linkTo(gMedio); bottom.linkTo(gInferior); height = Dimension.fillToConstraints
        })
        Box(Modifier.fillMaxWidth().background(Color(0xFFC8102E)).constrainAs(rojo) {
            top.linkTo(gInferior); bottom.linkTo(parent.bottom); height = Dimension.fillToConstraints
        })
    }
}