package com.example.kotlin_test2.ui

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.kotlin_test2.data.UserDataUiEvents
import com.example.kotlin_test2.data.UserInputScreenState

class UserInputViewModel: ViewModel(){


    companion object{
        const val TAG = "UserInputViewModel"

    }

    var uiState = mutableStateOf(UserInputScreenState())

    fun onEvent(event: UserDataUiEvents){

        when(event){

            is UserDataUiEvents.UserNameEntered -> {
                // mutableStateOf uiState use "value" and "copy" to access and modify
                // 使用copy 更改數據後 存回原value 可避免potential problem in multi-threading
                // 也可讓compose 偵測到畫面需要重新繪製
                uiState.value = uiState.value.copy(

                    nameEntered = event.name
                )
                Log.d(TAG, "onEvent: UserNameEntered ->> ")
                Log.d(TAG, "${uiState.value}")
            }

            is UserDataUiEvents.AnimalSelected -> {
                uiState.value = uiState.value.copy(

                    animalSelected = event.animalValue
                )
                Log.d(TAG, "onEvent: AnimalSelected ->> ")
                Log.d(TAG, "${uiState.value}")
            }
        }
    }

    // check the state of the button
    fun isValidState() : Boolean{
        return !uiState.value.nameEntered.isNullOrEmpty() && !uiState.value.animalSelected.isNullOrEmpty()
    }
}
