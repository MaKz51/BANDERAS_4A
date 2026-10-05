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
                    BanderaUSAConstraint(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BanderaUSAConstraint(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (franjas, canton) = createRefs()
        val guiaAncho = createGuidelineFromStart(0.4f)
        val guiaAlto = createGuidelineFromTop(0.54f)

        Column(modifier = Modifier.fillMaxSize().constrainAs(franjas) {
            top.linkTo(parent.top); bottom.linkTo(parent.bottom)
            start.linkTo(parent.start); end.linkTo(parent.end)
        }) {
            repeat(13) { index ->
                Box(Modifier.weight(1f).fillMaxWidth().background(if (index % 2 == 0) Color(0xFFB22234) else Color.White))
            }
        }

        Box(modifier = Modifier.background(Color(0xFF3C3B6E)).constrainAs(canton) {
            top.linkTo(parent.top); bottom.linkTo(guiaAlto)
            start.linkTo(parent.start); end.linkTo(guiaAncho)
            width = Dimension.fillToConstraints; height = Dimension.fillToConstraints
        })
    }
}