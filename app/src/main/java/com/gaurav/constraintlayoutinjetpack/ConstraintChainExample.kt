package com.gaurav.constraintlayoutinjetpack

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun HorizontalConstraintChainExample() {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        // Create references
        val (button1, button2, button3) = createRefs()

        createHorizontalChain(button1, button2, button3, chainStyle = ChainStyle.Spread)

        Button(
            onClick = {},
            modifier = Modifier.constrainAs(button1) {
                top.linkTo(parent.top, margin = 20.dp)
            }
        ) {
            Text("Button 1")
        }

        Button(
            onClick = {},
            modifier = Modifier.constrainAs(button2) {
                top.linkTo(parent.top, margin = 20.dp)
            }
        ) {
            Text("Button 2")
        }

        Button(
            onClick = {},
            modifier = Modifier.constrainAs(button3) {
                top.linkTo(parent.top, margin = 20.dp)
            }
        ) {
            Text("Button 3")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HorizontalConstraintChainExamplePreview() {
    HorizontalConstraintChainExample()
}