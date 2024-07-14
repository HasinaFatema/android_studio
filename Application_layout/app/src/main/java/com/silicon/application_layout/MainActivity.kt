package com.silicon.application_layout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.ui.Alignment
import com.silicon.application_layout.ui.theme.Application_layoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            Application_layoutTheme {
                Column{
                    Arrangement()
                    Spacer(modifier = Modifier.height(15.dp))
                    TextModifier()
                    Spacer(modifier = Modifier.height(20.dp))
                    AlignmentToColumn()
                    Spacer(modifier = Modifier.height(25.dp))
                    ImplementingBox()
                    Spacer(modifier = Modifier.height(30.dp))
                    ArrangementToRow()
                    Spacer(modifier = Modifier.height(40.dp))

                }
            }
        }
    }
}
@Composable
fun Arrangement(){
    Column {
        Text(
            text = "HEY !! Developers",
            color = Color.Magenta,
            fontStyle = FontStyle.Italic
        )
        Row(modifier = Modifier
            .padding(5.dp)
            .background(Color.Red)){
            Text(text = "Welcome to ")
            Text(text = "second class")
            Column {
                Text(text = "How are you all?")
            }
        }
    }
}

@Composable
fun TextModifier(){
    Text(text = "Hello! All of you",
     color = Color.Red,
       modifier = Modifier
           .padding(5.dp)
           .background(Color.Cyan)
           .fillMaxWidth()
    )
}

@Composable
fun AlignmentToColumn(){
    Column (modifier = Modifier
        .background(Color.Magenta)
        .fillMaxWidth()
        .padding(7.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text(text = "Welcome",
            modifier = Modifier
                .padding(2.dp))
        Text(text = "Lets get started",
            modifier = Modifier
                .padding(2.dp))


    }
}

@Composable
fun ArrangementToRow(){
    Row (modifier = Modifier
        .background(Color.Green)
        .fillMaxSize()
        .padding(7.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.End)
    {
        Text(text = "Hiii",
            modifier = Modifier
                .padding(2.dp))
        Text(text = "All good?",
            modifier = Modifier
                .padding(2.dp))


    }
}

@Composable
fun ImplementingBox(){
    Box {
        Text(text = "Hii")
        Text(text = "helllooooo")
    }
}