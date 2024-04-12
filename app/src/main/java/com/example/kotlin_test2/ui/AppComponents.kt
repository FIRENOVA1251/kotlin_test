package com.example.kotlin_test2.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlin_test2.R
import com.example.kotlin_test2.data.UserDataUiEvents

@Composable
fun TopBar(value: String){
    Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically){

        Text(
            text = value,
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.weight(1f))
        Image(
            modifier = Modifier.size(80.dp),
            painter = painterResource(id = R.drawable.victor_logo_wbg),
            contentDescription = "Native Mobile Bits"
        )
    }
}

@Composable
fun TextComponent(textValue: String,
                  textSize: TextUnit,
                  colorValue: Color = Color.Black){

    Text(text = textValue,
        fontSize = textSize,
        color = colorValue,
        fontWeight = FontWeight.Light
        )
}

@OptIn(ExperimentalMaterial3Api:: class)
@Composable
fun TextFieldComponent(
    onTextChanged : (name: String) -> Unit
){

    var currentValue by remember{
        mutableStateOf("")

    }

    val localFocusManager = LocalFocusManager.current
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = currentValue,

        // If user type anything, strings goes here
        onValueChange = {
            currentValue = it
            onTextChanged(it)

        },
        //Default text
        placeholder = {
            Text(text = "Enter your name", fontSize = 18.sp)
        },

        textStyle = TextStyle.Default.copy(fontSize = 24.sp),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions {
            localFocusManager.clearFocus()
        }
    )

}


@Composable
// Selected means selected or not
fun AnimalCard(image: Int, selected: Boolean,
               animalSelected: (animalName:String) -> Unit ){

    val localFocusManager = LocalFocusManager.current
    Card(

        modifier = Modifier
            .padding(24.dp)
            .size(130.dp),
        elevation = CardDefaults.cardElevation(4.dp)

    ){

        Box(

            modifier = Modifier
                .fillMaxSize()
                .border(
                    width = 1.dp,
                    color = if (selected) Color.Green else Color.Transparent,
                    shape = RoundedCornerShape(8.dp)
                )

        ){
            Image(
                modifier = Modifier
                    .padding(16.dp)
                    .wrapContentWidth()
                    .wrapContentHeight()
                    .clickable {

                        val animalName = if (image == R.drawable.red) "Red" else "Purple"
                        animalSelected(animalName)
                        localFocusManager.clearFocus()
                    },
                painter = painterResource(id = image),
                contentDescription = "Animal Image"

            )
        }
    }
}


@Composable
fun ButtonComponent(
    // 有事件 又需要傳遞資訊時  就使用lambda
    goToDetailsScreen: () -> Unit
){

    Button(

        modifier = Modifier.fillMaxWidth(),
        onClick = {
            goToDetailsScreen()
        }){
        TextComponent(textValue = "Go to Details Screen",
            textSize = 18.sp,
            colorValue = Color.White
        )

    }
}

@Composable
fun TextWithShadow(value: String, color: String){

    val shadowOffset = Offset(x = 1f, y = 2f)

    Text(
        text = value,
        fontSize = 20.sp,
        fontWeight = FontWeight.Light,
        style = TextStyle(
            shadow = Shadow(if(color=="red") Color.Red else Color.Green, shadowOffset, 2f)
        )
    )
}

@Composable
fun FactComposable(value: String){

    Card(
        modifier = Modifier
            .padding(32.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ){


        Column(
            modifier = Modifier.padding(18.dp),
            horizontalAlignment =  Alignment.CenterHorizontally,


        ) {
            Image(painter = painterResource(id = R.drawable.victor_logo_wbg),
                contentDescription = "Logo",
                Modifier.size(100.dp))

            Spacer(modifier = Modifier.size(10.dp))

            TextWithShadow(value = value, color = "red")

        }
    }
}


@Preview(showBackground = true)
@Composable
fun TopBarPreview(){

    FactComposable("1231312312")
}