package com.example.eldarwallet.util

sealed class Screen (val route: String) {

    object HomeScreen: Screen("home_screen")
    object LoginScreen: Screen("login_screen")
    object AgregarTarjeta: Screen("agregar_tarjeta")

}