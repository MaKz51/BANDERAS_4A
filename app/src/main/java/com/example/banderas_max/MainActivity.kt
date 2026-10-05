package com.example.banderas_max

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                    BanderaAlemaniaConstraint(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BanderaAlemaniaConstraint(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (negro, rojo, amarillo) = createRefs()
        val g1 = createGuidelineFromTop(0.333f)
        val g2 = createGuidelineFromTop(0.666f)
        Box(Modifier.fillMaxWidth().background(Color.Black).constrainAs(negro) {
            top.linkTo(parent.top); bottom.linkTo(g1); height = Dimension.fillToConstraints
        })
        Box(Modifier.fillMaxWidth().background(Color(0xFFDD0000)).constrainAs(rojo) {
            top.linkTo(g1); bottom.linkTo(g2); height = Dimension.fillToConstraints
        })
        Box(Modifier.fillMaxWidth().background(Color(0xFFFFCE00)).constrainAs(amarillo) {
            top.linkTo(g2); bottom.linkTo(parent.bottom); height = Dimension.fillToConstraints
        })
    }
}