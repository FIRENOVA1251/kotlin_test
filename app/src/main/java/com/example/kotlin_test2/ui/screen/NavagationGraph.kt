package com.example.kotlin_test2.ui.screen

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlin_test2.data.UserDataUiEvents
import com.example.kotlin_test2.ui.UserInputViewModel

@Composable

fun NavigationGraph(userInputViewModel: UserInputViewModel = viewModel()){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.USER_INPUT_SCREEN){

        composable(Routes.USER_INPUT_SCREEN){
            UserInputScreen(userInputViewModel, navController)
        }

        composable(Routes.WELCOME_SCREEN){
            WelcomeScreen(userInputViewModel, navController)
        }
    }
}