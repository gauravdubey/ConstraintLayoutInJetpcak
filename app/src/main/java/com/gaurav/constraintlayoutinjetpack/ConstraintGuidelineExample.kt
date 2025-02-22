package com.gaurav.constraintlayoutinjetpack

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ConstraintGuidelineExample() {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val guideline = createGuidelineFromStart(0.3f) // 30% of screen width

        val text = createRef()

        Text(
            text = "Aligned with a guideline!",
            modifier = Modifier.constrainAs(text) {
                start.linkTo(guideline) // Align text with the guideline
                top.linkTo(parent.top, margin = 50.dp)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ConstraintGuidelineExamplePreview(){
    ConstraintGuidelineExample()
}
