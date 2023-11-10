package com.example.kotlin_compose_basics.shared_components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ListItemSample(
    idx: Int,
    modifier: Modifier = Modifier,
    fontFamily: FontFamily,
    title: String,
    count: Int,
) {
    Text(
        text = title,
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .wrapContentSize(Alignment.Center),
        style = TextStyle(
            fontFamily = fontFamily,
            fontSize = 30.sp,
            fontWeight = FontWeight.Light,
            textDecoration = TextDecoration.Underline
        )

    )

    if (idx != count) {
        Spacer(
            modifier = modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(Color.Gray)
        )
    }
}