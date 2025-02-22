package com.gaurav.constraintlayoutinjetpack

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun BarrierExample() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        val (textShort, textLong, button) = createRefs()
        val barrier = createEndBarrier(textShort, textLong)

        Text(
            text = "Short Text",
            modifier = Modifier.constrainAs(textShort) {
                top.linkTo(parent.top, margin = 20.dp)
                start.linkTo(parent.start, margin = 16.dp)
            }
        )

        Text(
            text = "This is a long text that's length may varies",
            modifier = Modifier.constrainAs(textLong) {
                top.linkTo(textShort.bottom, margin = 10.dp)
                start.linkTo(parent.start, margin = 16.dp)
            }
        )

        Button(
            onClick = {},
            modifier = Modifier.constrainAs(button) {
                start.linkTo(barrier, margin = 16.dp) // Button aligns after the longest text
                top.linkTo(textLong.top)
            }
        ) {
            Text("Button")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BarrierExamplePreview() {
    BarrierExample()
}