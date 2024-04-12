package com.example.kotlin_test2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlin_test2.ui.screen.NavigationGraph
import com.example.kotlin_test2.ui.screen.Routes
import com.example.kotlin_test2.ui.screen.UserInputScreen
import com.example.kotlin_test2.ui.screen.WelcomeScreen
import com.example.kotlin_test2.ui.theme.Kotlin_test2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Kotlin_test2Theme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    NavigationGraph()
}
