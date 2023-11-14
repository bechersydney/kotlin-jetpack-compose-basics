package com.example.kotlin_compose_basics.shared_components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

@Composable
fun ConstraintLayoutSample(
    modifier: Modifier = Modifier
) {
    val constraints = ConstraintSet {
        val greenBox = createRefFor("greenbox")
        val redBox = createRefFor("redbox")
        val guideLine = createGuidelineFromTop(0.5f)
        createHorizontalChain(greenBox, redBox, chainStyle = ChainStyle.Packed)
        constrain(greenBox) {
            top.linkTo(guideLine)
            start.linkTo(parent.start)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }
        constrain(redBox) {
            top.linkTo(parent.top)
            start.linkTo(greenBox.end)
            end.linkTo(parent.end)
            width = Dimension.value(100.dp)
//            width = Dimension.fillToConstraints
            height = Dimension.value(100.dp)
        }
    }
    ConstraintLayout(constraintSet = constraints, modifier = modifier.fillMaxSize()) {
        Box(modifier = modifier
            .background(Color.Green)
            .layoutId("greenbox"))
        Box(modifier = modifier
            .background(Color.Red)
            .layoutId("redbox"))
    }
}