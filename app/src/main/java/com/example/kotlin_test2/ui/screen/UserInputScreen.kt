package com.example.kotlin_test2.ui.screen

import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.kotlin_test2.R
import com.example.kotlin_test2.data.UserDataUiEvents
import com.example.kotlin_test2.ui.AnimalCard
import com.example.kotlin_test2.ui.ButtonComponent
import com.example.kotlin_test2.ui.TextComponent
import com.example.kotlin_test2.ui.TextFieldComponent
import com.example.kotlin_test2.ui.TopBar
import com.example.kotlin_test2.ui.UserInputViewModel


@Composable

fun UserInputScreen(userInputViewModel: UserInputViewModel, navController: NavHostController) {

    Surface(
        modifier = Modifier
            .fillMaxSize()

    ){

        Column(

           modifier = Modifier
               .fillMaxSize()
               .padding(18.dp)
        ){
            TopBar("Hi there !! \uD83D\uDE0A")

            TextComponent(
                textValue = "Let's learn about You!",
                textSize = 24.sp
            )

            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(
                textValue = "I want to have a Java chip tonight!",
                textSize = 18.sp
            )

            Spacer(modifier = Modifier.size(60.dp))

            TextComponent(
                textValue = "Name",
                textSize = 18.sp
            )

            Spacer(modifier = Modifier.size(10.dp))

            TextFieldComponent(onTextChanged = {

                userInputViewModel.onEvent(UserDataUiEvents.UserNameEntered(it))
            })

            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(
                textValue = "What do you want",
                textSize = 18.sp
            )

            Row(modifier = Modifier.fillMaxWidth()){

                AnimalCard(image = R.drawable.red, animalSelected = {
                    userInputViewModel.onEvent(
                        UserDataUiEvents.AnimalSelected(it)
                    )
                }, selected = userInputViewModel.uiState.value.animalSelected=="Red")
                AnimalCard(image = R.drawable.purple, animalSelected = {
                    userInputViewModel.onEvent(
                        UserDataUiEvents.AnimalSelected(it)
                    )
                },selected = userInputViewModel.uiState.value.animalSelected=="Purple")
            }

            Spacer(modifier = Modifier.weight(1f))


            if (userInputViewModel.isValidState()){
                ButtonComponent(
                    goToDetailsScreen = {
                        navController.navigate(Routes.WELCOME_SCREEN)

                    }
                )
            }


        }

    }
}

@Preview
@Composable
fun UserInputScreenPreview(){
    UserInputScreen(UserInputViewModel(), rememberNavController())
}