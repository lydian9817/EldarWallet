package com.example.eldarwallet.util

sealed class Screen (val route: String) {

    object HomeScreen: Screen("home_screen")
    object LoginScreen: Screen("login_screen")
    object AgregarTarjetaScreen: Screen("agregar_tarjeta_screen")
    object PagoQrScreen: Screen("pago_qr_screen")
    object GenerarPagoScreen: Screen("generar_pago_screen")
    object DetalleDeTarjetaScreen: Screen("detalle_screen")



}