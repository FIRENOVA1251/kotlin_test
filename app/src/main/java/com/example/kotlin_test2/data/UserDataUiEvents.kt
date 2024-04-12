package com.example.kotlin_test2.data

sealed class UserDataUiEvents{

    data class UserNameEntered(val name: String) : UserDataUiEvents()
    data class AnimalSelected(val animalValue: String) : UserDataUiEvents()

}