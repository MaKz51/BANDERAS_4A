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
import androidx.compose.ui.Alignment
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
                    BanderaArgentina(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BanderaArgentinaConstraint(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (celeste1, blanco, celeste2, sol) = createRefs()
        val g1 = createGuidelineFromTop(0.333f)
        val g2 = createGuidelineFromTop(0.666f)

        Box(Modifier.fillMaxWidth().background(Color(0xFF74ACDF)).constrainAs(celeste1) {
            top.linkTo(parent.top); bottom.linkTo(g1); height = Dimension.fillToConstraints
        })
        Box(Modifier.fillMaxWidth().background(Color.White).constrainAs(blanco) {
            top.linkTo(g1); bottom.linkTo(g2); height = Dimension.fillToConstraints
        })
        Box(Modifier.fillMaxWidth().background(Color(0xFF74ACDF)).constrainAs(celeste2) {
            top.linkTo(g2); bottom.linkTo(parent.bottom); height = Dimension.fillToConstraints
        })
        Box(Modifier.size(50.dp).clip(CircleShape).background(Color(0xFFF6B40E)).constrainAs(sol) {
            start.linkTo(parent.start); end.linkTo(parent.end)
            top.linkTo(parent.top); bottom.linkTo(parent.bottom)
        })
    }
}