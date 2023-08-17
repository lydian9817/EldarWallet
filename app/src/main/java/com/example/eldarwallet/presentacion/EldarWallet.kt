package com.example.eldarwallet.presentacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.eldarwallet.navegacion.NavHost

@Composable
fun EldarWallet(
    viewModel: MainViewModel = MainViewModel()
) {
    val navController = rememberNavController()

    NavHost(navController = navController, viewModel)
}