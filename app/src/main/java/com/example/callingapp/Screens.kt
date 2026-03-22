package com.example.callingapp

sealed class Screen(val route: String) {
    object DialPad : Screen("dialpad")
    object Calling : Screen("calling")
    object Incoming : Screen("incoming")
    object Active : Screen("active")
}