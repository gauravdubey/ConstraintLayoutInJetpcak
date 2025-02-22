package com.gaurav.constraintlayoutinjetpack

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun AnimatedButtonExample() {
    var moved by remember { mutableStateOf(false) }
    val animatedMargin by animateDpAsState(targetValue = if (moved) 200.dp else 50.dp)

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding()
    ) {
        val button = createRef()

        Button(
            onClick = { moved = !moved },
            modifier = Modifier
                .widthIn(100.dp)
                .constrainAs(button) {
                    top.linkTo(parent.top, margin = animatedMargin)
                    start.linkTo(parent.start)
                }
        ) {
            Text("Click Me")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AnimatedButtonExamplePreview() {
    AnimatedButtonExample()
}
