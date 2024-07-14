package com.silicon.application_ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.silicon.application_ui.ui.theme.Application_UITheme
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Switch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val value by remember {
                mutableFloatStateOf(0f)
            }
            Application_UITheme {
                Column (
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxSize()
                ) {
                    createSimpleButton()
                    Spacer(modifier = Modifier.height(15.dp))
                    createElevatedButton()
                    Spacer(modifier = Modifier.height(20.dp))
                    createFloatingAction()
                    Spacer(modifier = Modifier.height(25.dp))
                    CreateCard()
                    Spacer(modifier = Modifier.height(30.dp))
                    CreateSlider()
                    Spacer(modifier = Modifier.height(35.dp))
                    SwitchTest()
                    Spacer(modifier = Modifier.height(40.dp))
                    CreateBadge()
                    Spacer(modifier = Modifier.height(45.dp))
                    CreateOutlinedButton()
                    Spacer(modifier = Modifier.height(50.dp))
                    FilterChipExample()
                    Spacer(modifier = Modifier.height(55.dp))
                }
            }
        }
    }
}

@Composable
fun createSimpleButton(){
        Button(onClick = { println("Message:- Clicked") },
            colors = ButtonDefaults.buttonColors(Color.Green)) {
            Text(text = "TAP",color=Color.Black)
    }
}

@Composable
fun  createElevatedButton(){
    ElevatedButton(onClick = { println("Message:- ClickedEB") },
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(Color.Blue)){
        Text(text = "CLICK",color=Color.Magenta)
    }
}

@Composable
fun createFloatingAction(){
    FloatingActionButton(onClick = { println("Message:- CLICKED")},
        shape= RoundedCornerShape(5.dp),
        containerColor = Color.Red)
    {
        Icon(
            Icons.Rounded.Delete,
            contentDescription = ""
        )
    }
}
@Composable
fun CreateCard(){
    Card (
        colors = CardDefaults.cardColors(
            containerColor = Color.Green,
            contentColor = Color.Red
        ),
        modifier = Modifier
            .size(width= 200.dp, height=100.dp)
    ){
        Text(text = "Welcome! Good evening \uD83D\uDE03\uD83D\uDE03")
    }
}
@Composable
fun CreateSlider() {
    var sliderPos by remember { mutableStateOf(0f) }
    Column {
        Slider(
            value = sliderPos,
            onValueChange = { sliderPos= it },
            colors = SliderDefaults.colors(
                thumbColor = Color.Black,
                activeTrackColor = Color.DarkGray,
                inactiveTrackColor = Color.Blue.copy(alpha = 0.24f)
            )
        )
        Text(text = sliderPos.toString())
    }
}

@Composable
fun SwitchTest() {

    var checked by remember { mutableStateOf(true) }

    Switch(
        checked = checked,
        onCheckedChange = {
            checked = it
        }
    )
}

@Composable
fun CreateBadge() {
    BadgedBox(
        badge = {
            Badge()
        }
    ) {
        Icon(
            imageVector = Icons.Filled.Home,
            contentDescription = "Instagram"
        )
    }
}

@Composable
fun CreateOutlinedButton() {
    OutlinedButton(
        onClick =
        { println("Message:- CLICKED")},
        shape = RectangleShape
    ) {
        Text(text = "Outlined",color=Color.Green)
    }
}

@Composable
fun FilterChipExample() {
    var selected by remember { mutableStateOf(false) }

    FilterChip(
        onClick = { selected = !selected },
        label = {
            Text("Filter chip")
        },
        selected = selected,
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "CLOSE icon",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        },
    )
}