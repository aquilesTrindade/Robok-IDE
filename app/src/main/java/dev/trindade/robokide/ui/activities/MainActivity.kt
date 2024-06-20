package dev.trindade.robokide.ui.activities

import android.os.Bundle

import androidx.activity.*
import androidx.navigation.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.platform.*
import androidx.compose.ui.draw.*
import androidx.activity.compose.*
import androidx.compose.runtime.*
import androidx.compose.ui.layout.*
import androidx.compose.material3.*
import androidx.navigation.compose.*
import androidx.compose.foundation.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.input.*
import androidx.compose.material.icons.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.layout.*

import dev.trindade.robokide.ui.theme.*

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RobokTheme {
                Scaffold(
                    modifier = 
                      Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    Content()
                }
            }
        }
    }
    
    @Composable
    fun Content () {
        Column ( 
           modifier = Modifier
             .fillMaxSize()
             .padding(16.dp)
        ) {
            var code by remember {
                mutableStateOf(TextFieldValue("showToast Hello&{space}World!"))
            }
            TextField(
                value = code,
                onValueChange = { newValue ->
                    code = newValue
                },
                label = { Text("Code") }
            )
            
            Button(
               onClick = { 
                  //executeRobokLanguage(code.text)
               }
            ) {
                Text(
                   text = "RUN"
                )
            }
        }
    }
    
    @Composable
    fun executeRobokLanguage(code: String) {
        
    }
} 