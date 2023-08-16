package com.example.eldarwallet.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.eldarwallet.presentation.MainViewModel
import com.example.eldarwallet.presentation.agregartarjeta.AgregarTarjeta
import com.example.eldarwallet.presentation.home.HomeScreen
import com.example.eldarwallet.presentation.login.LoginScreen
import com.example.eldarwallet.util.Screen

@Composable
fun NavHost(
    navController: NavHostController,
    viewModel: MainViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screen.LoginScreen.route) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(
                irAAgregarTarjeta = {
                    navController.navigate(Screen.AgregarTarjeta.route)
                }
            )
        }
        composable(route = Screen.LoginScreen.route) {
            LoginScreen(
                login = {
                    navController.navigate(Screen.HomeScreen.route)
                },
                viewModel = viewModel
            )
        }
        composable(route = Screen.AgregarTarjeta.route){
            AgregarTarjeta(
                viewModel = viewModel
            )
        }
    }
}