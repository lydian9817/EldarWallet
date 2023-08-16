package com.example.eldarwallet.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.eldarwallet.navigation.NavHost

@Composable
fun EldarWallet(
    viewModel: MainViewModel = MainViewModel()
) {
    val navController = rememberNavController()

    NavHost(navController = navController, viewModel)
}