package com.example.kotlin_compose_basics.shared_components

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color

@Composable
fun SimpleAnimation(
    modifier: Modifier = Modifier,
) {
    var sizeState by remember {
        mutableStateOf(200.dp)
    }
    val size by animateDpAsState(
        targetValue = sizeState,
//        animationSpec = tween(
//            durationMillis = 3000,
//            delayMillis = 300,
//            easing = FastOutSlowInEasing
//        )
//        animationSpec = spring(
//            Spring.DampingRatioHighBouncy
//        )
    )
    val infiniteTransition  = rememberInfiniteTransition()
    val color by infiniteTransition.animateColor(
        initialValue = Color.Red,
        targetValue = Color.Black,
//        animationSpec = infiniteRepeatable(tween(
//            durationMillis = 3000,
//            delayMillis = 100,
//            easing = FastOutSlowInEasing
//        ))
        animationSpec = infiniteRepeatable(
            tween(durationMillis = 2000),
            repeatMode = RepeatMode.Reverse
        )
    )
    Box(modifier = modifier
        .size(size)
        .background(color = color)
        .clickable {
            sizeState += 50.dp
        }
    ) {

    }
}