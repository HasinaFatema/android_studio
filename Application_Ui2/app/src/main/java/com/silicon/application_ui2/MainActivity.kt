package com.silicon.application_ui2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.silicon.application_ui2.ui.theme.Application_Ui2Theme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Application_Ui2Theme {
                    CreateScaffold()

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateScaffold(){
    var click by remember {
        mutableStateOf(0)
    }
    Scaffold(
        topBar = {
            TopAppBar(colors = topAppBarColors (
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.tertiary
            ),
                title = { Text(text = "MyTopAppBar")}
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.tertiary
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Right,
                    text = "My Bottom App Bar")
            }
        },

        floatingActionButton = {
            FloatingActionButton(onClick = { click ++ }) {
                Icon(Icons.Filled.Refresh, contentDescription = "Refresh")
            }
        }


    ) {
            innerPadding ->
        var sheetState = rememberModalBottomSheetState()
        var showBottomSheet by remember {
            mutableStateOf(false)
        }
        var showAlert by remember {
            mutableStateOf(false)
        }
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(text = """This is an example of SCAFFOLD.
                |
                |
                |You have pressed the $click times
            """.trimMargin())
            Button(onClick = { showBottomSheet = true }) {
                Text(text = "Open Bottom Sheet")
            }
            Button(onClick = {showAlert = true}) {
                Text(text = "Show Emergency Info")
            }
        }

        if (showAlert) {
            AlertDialogExample()
        }
        if(showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = { showBottomSheet = false },
                sheetState = sheetState,
                containerColor = MaterialTheme.colorScheme.error
            ) {
                Column(modifier  = Modifier
                    .padding(15.dp)
                    .fillMaxSize()) {
                    Text(text ="Welcome to bottom sheet")

                }
            }
        }
    }
}

@Composable
fun AlertDialogExample() {

    AlertDialog(
        icon = { Icon(Icons.Filled.Info, contentDescription = "Info") },

        title = {
            Text(text = "Important")
        },
        text = {
            Text(text = "This App is in Update Mode")
        },
        onDismissRequest = {},
        confirmButton = { TextButton(onClick = { println("Message:i clicked") }) {
            Text(text = "Alright")
        } }
    )
}
