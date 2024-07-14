package com.silicon.application_mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.ai.client.generativeai.type.content
import com.silicon.application_mvvm.ui.theme.Application_MVVMTheme

abstract class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            Application_MVVMTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    CounterView()
                }
            }
        }
    }
    @Composable
    fun CounterView(counterVM:CounterViewModel = viewModel())
    {
        val intContent = GenericClass(120)
        val stringContent = GenericClass ("Hello World")
        val counterState = counterVM.counter.value
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(text = "Current Counter value: ${counterState.count}")
            Row{
                Button(onClick = { counterVM.IncrementCounter() }) {
                    Text(text = "Increment")
                }
                Spacer(modifier =Modifier.width(20.dp))
                Button(onClick = { counterVM.DecrementCounter() }) {
                    Text(text = "Decrement")
                }
                Spacer(modifier =Modifier.width(20.dp))
            }
            Button(onClick = { counterVM.resetCounter()}) {
                Text(text = "Reset")
            }
            Spacer(modifier =Modifier.height(20.dp))
            Button(onClick = {
                counterVM.login()
                println("$ {intContent.content},$ {stringContent.content}")
            }) {
                Text(text = "Login")
            }
            }
        }
    }


//Model Class
data class Counter(val count:Int)
data class User(val username: String,val password: String)

//ViewModel Class
class CounterViewModel:ViewModel (){
    private val _counter = mutableStateOf(Counter(0))
    val counter: State<Counter> = _counter
    fun IncrementCounter(){
        _counter.value=Counter(_counter.value.count + 1)
        }
    fun DecrementCounter(){
        _counter.value=Counter(_counter.value.count - 1)
    }
    fun resetCounter(){
        _counter.value = Counter(0)
    }
    fun login(){
        //Logic
    }
}

class GenericClass<T>(var content: T)