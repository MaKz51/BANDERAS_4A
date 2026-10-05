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
                    BanderaEspanaConstraint(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BanderaEspanaConstraint(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (rojoSup, amarillo, rojoInf) = createRefs()
        val gTop = createGuidelineFromTop(0.25f)
        val gBottom = createGuidelineFromTop(0.75f)
        Box(Modifier.fillMaxWidth().background(Color(0xFFAA151B)).constrainAs(rojoSup) {
            top.linkTo(parent.top); bottom.linkTo(gTop); height = Dimension.fillToConstraints
        })
        Box(Modifier.fillMaxWidth().background(Color(0xFFF1BF00)).constrainAs(amarillo) {
            top.linkTo(gTop); bottom.linkTo(gBottom); height = Dimension.fillToConstraints
        })
        Box(Modifier.fillMaxWidth().background(Color(0xFFAA151B)).constrainAs(rojoInf) {
            top.linkTo(gBottom); bottom.linkTo(parent.bottom); height = Dimension.fillToConstraints
        })
    }
}