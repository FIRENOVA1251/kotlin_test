package com.example.kotlin_test2.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import com.example.kotlin_test2.ui.FactComposable
import com.example.kotlin_test2.ui.TextComponent
import com.example.kotlin_test2.ui.TextFieldComponent
import com.example.kotlin_test2.ui.TextWithShadow
import com.example.kotlin_test2.ui.TopBar
import com.example.kotlin_test2.ui.UserInputViewModel

@Composable

fun WelcomeScreen(userInputViewModel: UserInputViewModel, navController: NavHostController
                  ) {


    Surface(
        modifier = Modifier
            .fillMaxSize()
            .clickable {

                navController.navigate(Routes.USER_INPUT_SCREEN)
            }

    ){
        Column(

            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        ){

            val username = userInputViewModel.uiState.value.nameEntered
            val animalSelected = userInputViewModel.uiState.value.animalSelected

            TopBar("Hi $username !! \uD83D\uDE0D")

            TextComponent(
                textValue = "Thank you for sharing your data!",
                textSize = 24.sp
            )

            Spacer(modifier = Modifier.size(60.dp))

            TextComponent(
                textValue = "The color you love is $animalSelected!",
                textSize = 18.sp
            )

            val finalText = "The color you love is $animalSelected!"
            TextWithShadow(value = finalText, animalSelected!!)

            Spacer(modifier = Modifier.size(60.dp))


            FactComposable(value = "1231312312313123")


        }
    }
}

@Preview
@Composable
fun WelcomeScreenPreview(){
    WelcomeScreen(UserInputViewModel(), rememberNavController())
}