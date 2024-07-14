package com.silicon.application_text

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.silicon.application_text.ui.theme.Application_TextTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Application_TextTheme {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)) {
                    BigText()
                    Spacer(modifier = Modifier.height(15.dp))
                    TextColor()
                    Spacer(modifier = Modifier.height(20.dp))
                    BoldText()
                    Spacer(modifier= Modifier.height(25.dp))
                    TextShadow()
                    Spacer(modifier = Modifier.height(30.dp))
                    MultipleStylesInText()
                    Spacer(modifier = Modifier.height(35.dp))
                    TextFont()
                    Spacer(modifier = Modifier.height(40.dp))
                    AddEmoji()
                    Spacer(modifier = Modifier.height(45.dp))
                    GradientText()
                }
            }
        }
    }
}

@Composable
fun BigText() {
    Text(text = "Hi!Its HASINA here", fontSize = 20.sp)
}
@Composable
fun TextColor() {
    Text(text = "Welcome to App Development", color= Color.Green)
}

@Composable
fun BoldText() {
    Text(text = "Font convert to BOLD", fontWeight = FontWeight.Bold, color =Color.Red)
}

@Composable
fun TextShadow() {
    val offset = Offset(5.0f, 10.0f)
    Text(
        text = "Shadow added",
        style = TextStyle(
            fontSize = 25.sp,
            shadow = Shadow(
                color = Color.Magenta, offset = offset, blurRadius = 3f
            )
        )
    )
}
@Composable
fun MultipleStylesInText() {
    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.Blue)) {
                append("H")
            }
            append("eyy!")

            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Red)) {
                append("W")
            }
            append("elcome")
        }
    )
}
@Composable
fun TextFont() {
    Text(
        text = "Text converted to Italics",
        fontStyle = FontStyle.Italic,
        color = Color(0xFFFFA500),  // Hex value for orange
        fontSize = 20.sp
    )
}
@Composable
fun GradientText(){
    val gradientColors = listOf(Color.Red, Color.Blue, Color.Yellow)
    Text(
        text = "Thank You! ",
        style = TextStyle(
            brush = Brush.linearGradient(
                colors = gradientColors
            ),
            fontSize = 18.sp
        )
    )
}

@Composable
fun AddEmoji() {
    val rainbowColors = listOf(
        Color.Red,
        Color(0xFFFFA500), // hex value for Orange
        Color.Yellow,
        Color.Green,
        Color.Blue,
        Color(0xFF4B0082), // hex value of Indigo
        Color(0xFFEE82EE)  // hex value of Violet
    )

    val brush = Brush.linearGradient(colors = rainbowColors)

    Text(
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    brush = brush, alpha = 0.5f
                )
            ) {
                append("Silicon University")
            }
            withStyle(
                style = SpanStyle(
                    brush = brush, alpha = 1f
                )
            ) {
                append(" Is A Emotion \uD83E\uDD29\uD83E\uDD29")
            }
        },
        fontSize = 20.sp
    )}

