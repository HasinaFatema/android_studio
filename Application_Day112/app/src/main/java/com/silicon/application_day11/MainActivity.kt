package com.silicon.application_day11

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.silicon.application_day11.ui.theme.Application_Day11Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Application_Day11Theme {
                CreateAppNavigation()
            }
        }
    }
}
@Composable
fun CounterScreen() {
    var count by remember {
        mutableStateOf(0)
    }
    Column(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Count Value: $count")
        Spacer(modifier = Modifier.height(5.dp))
        Button(onClick = { count++ }) {
            Text(text = "Increment")
        }
        Spacer(modifier = Modifier.height(5.dp))
        Button(onClick = { count-- }) {
            Text(text = "Decrement")
        }
    }
}

@Composable
fun CreateTextField(){
    var text by remember {
        mutableStateOf("")
    }
    TextField(value = text, onValueChange = {
        text=it
    },label={
        Text(text = "Enter Password:")
    }, visualTransformation = PasswordVisualTransformation())
}

@Composable
fun CreateAppNavigation(){
    var navController = rememberNavController()
    NavHost(navController = navController, startDestination = "screen1") {
        composable("screen1"){Screen1(navController)}
        composable("screen2"){Screen2(navController)}
        composable("screen3"){Screen3(navController)}
        composable("screen4/{data}",arguments = listOf(navArgument("data"){type= NavType.StringType})){ backStackEntry->
            Screen4(navController, backStackEntry.arguments?.getString("data")?:"")}
        composable("screen5"){Screen5(navController)}
    }
}

@Composable
fun Screen5(navController: NavController) {
    var itemList = List(50) { "item=$it" }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(text = "This is Screen5", fontSize = 30.sp, color = Color.Red)
        Spacer(modifier = Modifier.height(5.dp))
        Button(onClick = { navController.navigate("screen1") }) {
            Text(text = "Go to SCREEN1")
        }
        Spacer(modifier = Modifier.height(5.dp))
            LazyVerticalGrid(columns = GridCells.Adaptive(110.dp)) {
                items(itemList) {
                    Card {
                        Text(text = it)
                    }
                }
            }
        }
    }

    @Composable
    fun Screen4(navController: NavController, data: String) {
        Column {
            Text(text = "This is Screen4", fontSize = 30.sp, color = Color.Blue)
            Button(onClick = { navController.navigate("screen5") }) {
                Text(text = "Go to SCREEN5")
            }
        }
    }

    @Composable
    fun Screen3(navController: NavController) {
        var text by remember {
            mutableStateOf("")
        }
        Column {
            Text(text = "This is Screen3", fontSize = 30.sp, color = Color.Black)
            OutlinedTextField(value = text, onValueChange = {
                text = it
            })
            Button(onClick = { navController.navigate("screen4/$text") }) {
                Text(text = "Go to SCREEN4")
            }
        }
    }

    @Composable
    fun Screen2(navController: NavController) {
        Column {
            Text(text = "This is Screen2", fontSize = 30.sp, color = Color.Green)
            Button(onClick = { navController.navigate("screen3") }) {
                Text(text = "Go to SCREEN3")
            }
        }
    }

    @Composable
    fun Screen1(navController: NavController) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize()
        ) {
            CounterScreen()
            Spacer(modifier = Modifier.height(10.dp))
            CreateTextField()
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "This is Screen1", fontSize = 30.sp, color = Color.Magenta)
            Button(onClick = { navController.navigate("screen2") }) {
                Text(text = "Go to SCREEN2")
            }
        }
    }
