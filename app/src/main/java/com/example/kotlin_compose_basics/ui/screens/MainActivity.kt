package com.example.kotlin_compose_basics.ui.screens

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlin_compose_basics.R
import com.example.kotlin_compose_basics.shared_components.ConstraintLayoutSample
import com.example.kotlin_compose_basics.shared_components.ListItemSample
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fontFamily = FontFamily(
            Font(
                R.font.lexend_thin, FontWeight.Thin
            ),
            Font(
                R.font.lexend_light, FontWeight.Light
            ),
            Font(
                R.font.lexend_regular, FontWeight.Normal
            ),
            Font(
                R.font.lexend_medium, FontWeight.Medium
            ),
            Font(
                R.font.lexend_semi_bold, FontWeight.SemiBold
            ),
            Font(
                R.font.lexend_bold, FontWeight.Bold
            ),
            Font(
                R.font.lexend_extra_bold, FontWeight.ExtraBold
            ),
        )
        setContent {
//            RowSample()
//            ColumnSample()
//            val painter = painterResource(id = R.drawable.test)
//            val description = "Lipad isip gaw!"
//            val title = "Tingin Langit"
//            Box(
//                modifier = Modifier
//                    .fillMaxSize(.5f)
//                    .padding(16.dp)
//            ) {
//                ImageCardSample(
//                    contentDescription = description,
//                    painter = painter,
//                    title = title
//                )
//            }
//            TextStyleSample(textContent = "This is sample", fontFamily = fontFamily)
//            Column(modifier = Modifier.fillMaxSize()) {
//                val bg = remember {
//                    mutableStateOf(Color.Yellow)
//                }
//                SampleState(
//                    modifier = Modifier
//                        .weight(1f)
//                        .fillMaxSize()
//                ) {
//                    bg.value = it
//                }
//                Box(
//                    modifier = Modifier
//                        .background(bg.value)
//                        .weight(1f)
//                        .fillMaxSize()
//                )
//            }
//            TextFieldButtonsSnackBarSample()
//            ScrollableColumn()
//            LazyColumSample(fontFamily = fontFamily, modifier = Modifier.background(Color.Red))
            ConstraintLayoutSample()
        }

    }
}


@Preview
@Composable
fun RowSample() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(color = Color.Green)
    ) {
        Text(
            text = "Sydney",
            color = Color.Black,
            modifier = Modifier.border(width = 2.dp, color = Color.DarkGray, shape = CircleShape)
        )
        Text(text = "Becher", color = Color.Blue)
        Text(text = "Quijote", color = Color.Red)
    }
}

@Preview
@Composable
fun ColumnSample() {
    Column(
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .background(
                color = Color.Red,
                shape = RectangleShape
            )
            .width(200.dp) // if given width is larger than the actual device width, it will automatically use maxWidth
            .fillMaxHeight(0.5f)
//            .requiredWidth(600.dp) this will force to the width given in anyscreens

            .padding(horizontal = 10.dp)
            .border(width = 2.dp, color = Color.Black)
            .padding(horizontal = 5.dp)
            .border(width = 2.dp, color = Color.Yellow)
            .padding(horizontal = 10.dp)
            .border(width = 2.dp, color = Color.Green)
            .padding(horizontal = 5.dp)
            .border(width = 2.dp, color = Color.Magenta)
    ) {
        Text(
            text = "Boss",
            color = Color.White,
            modifier = Modifier.offset(50.dp, 20.dp)
        ) // work same as margin but it wont affect other component. same as position in css
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Toyo",
            color = Color.White,
            modifier = Modifier
                .border(width = 2.dp, color = Color.DarkGray, shape = CircleShape)
                .background(color = Color.Yellow)
        )
    }
}

@Composable
fun CreateCustomButton(modifier: Modifier, onClick: () -> Unit) {
    Button(onClick = onClick, modifier = modifier) {
        Text(text = "Click me")
//        Text(text = StringUtils.TIU_OTEN)
    }
}

@Composable
fun ImageCardSample(
    contentDescription: String,
    modifier: Modifier = Modifier,
    painter: Painter,
    title: String
) {
    Card(
        modifier = modifier.width(200.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 20.dp)
    ) {
        Box(modifier = Modifier.height(200.dp)) {// stack in flutter
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.FillWidth
            )
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black),
                            startY = 300f,
//                            endY = 800f
                        )
                    )
            )
            Text(
                text = title,
                style = TextStyle(color = Color.White, fontSize = 16.sp),
                modifier = modifier
                    .align(Alignment.BottomStart)
                    .padding(15.dp)
            )
        }

    }
}

@Composable
fun TextStyleSample(
    textContent: String,
    modifier: Modifier = Modifier,
    fontFamily: FontFamily
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFF101010))
    ) {
        Text(
            modifier = modifier.fillMaxSize(),
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.Green,
                        fontSize = 30.sp
                    )
                ) {
                    append("J")
                }
                append("etpack ")
                withStyle(
                    style = SpanStyle(
                        color = Color.Green,
                        fontSize = 30.sp
                    )
                ) {
                    append("C")
                }
                append("ompose")
            },
            style = TextStyle(
                color = Color.White,
                fontSize = 30.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.Underline
            )
        )
    }
}

@Composable
fun SampleState(
    modifier: Modifier = Modifier,
    updateColor: (Color) -> Unit
) {
    Box(modifier = modifier
        .background(Color.Red)
        .clickable {
            updateColor(
                Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    1f
                )
            )
        }
    )
}

@Composable
fun TextFieldButtonsSnackBarSample(
    modifier: Modifier = Modifier
) {
    val snackbarHostState = remember {
        SnackbarHostState()
    }
    var inputState by remember {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp),
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(it)
                .padding(horizontal = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = inputState,
                onValueChange = { value ->
                    inputState = value
                },
                label = {
                    Text(text = "Enter your name")
                },
                singleLine = true,
                modifier = modifier.fillMaxWidth()
            )
            Spacer(modifier = modifier.height(16.dp))
            Button(
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            message = "Hello $inputState",
                            duration = SnackbarDuration.Short
                        )
                    }
                },
                shape = RoundedCornerShape(8.dp),
                modifier = modifier
                    .align(Alignment.End),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
            ) {
                Text(text = "Click me", style = TextStyle(color = Color.White))
            }
        }
    }
}

@Composable
fun ScrollableColumn(
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(state = scrollState)
    ) {

        for (i in 1..20) {
            Column(
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "I am count $i",
                    modifier = modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .wrapContentSize(Alignment.Center)

                )

                if (i != 20) {
                    Spacer(
                        modifier = modifier
                            .height(1.dp)
                            .fillMaxWidth()
                            .background(Color.Gray)
                    )
                }
            }

        }
    }
}

@Composable
fun LazyColumSample(
    modifier: Modifier = Modifier,
    fontFamily: FontFamily
) {
    LazyColumn(modifier = modifier) {
        itemsIndexed( // equivalent to forEach
            items = listOf("This", "is", "my", "now")
        ) { i, str ->
            ListItemSample(
                idx = i,
                fontFamily = fontFamily,
                count = 4,
                title = str
            )
        }
//        items(count = 5000) { // equivalent to for(i in 1..5)
//            ListItemSample(it.toString(), fontFamily = fontFamily)
//        }
    }
}



