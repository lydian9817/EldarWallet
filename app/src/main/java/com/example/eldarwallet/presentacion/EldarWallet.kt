package com.example.eldarwallet.presentacion

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.eldarwallet.navegacion.NavHost

@Composable
fun EldarWallet(
    viewModel: MainViewModel = hiltViewModel()
) {
    val navController = rememberNavController()

    NavHost(navController = navController, viewModel)
}