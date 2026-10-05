package com.example.banderas_max
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.GenericShape
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
                    BanderaMexicoConstraint(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BanderaMexicoConstraint(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (verde, blanco, rojo, escudo) = createRefs()
        val g1 = createGuidelineFromStart(0.333f)
        val g2 = createGuidelineFromStart(0.666f)

        Box(Modifier.fillMaxHeight().background(Color(0xFF006341)).constrainAs(verde) {
            start.linkTo(parent.start); end.linkTo(g1); width = Dimension.fillToConstraints
        })
        Box(Modifier.fillMaxHeight().background(Color.White).constrainAs(blanco) {
            start.linkTo(g1); end.linkTo(g2); width = Dimension.fillToConstraints
        })
        Box(Modifier.fillMaxHeight().background(Color(0xFFCE1126)).constrainAs(rojo) {
            start.linkTo(g2); end.linkTo(parent.end); width = Dimension.fillToConstraints
        })
        Box(Modifier.size(50.dp).clip(CircleShape).background(Color(0xFFF6B40E)).constrainAs(escudo) {
            start.linkTo(blanco.start); end.linkTo(blanco.end)
            top.linkTo(blanco.top); bottom.linkTo(blanco.bottom)
        })
    }
}