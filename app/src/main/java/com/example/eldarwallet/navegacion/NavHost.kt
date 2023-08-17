package com.example.eldarwallet.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.eldarwallet.presentacion.MainViewModel
import com.example.eldarwallet.presentacion.agregartarjeta.AgregarTarjeta
import com.example.eldarwallet.presentacion.home.HomeScreen
import com.example.eldarwallet.presentacion.login.LoginScreen
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
                },
                viewModel = viewModel
            )
        }
        composable(route = Screen.LoginScreen.route) {
            LoginScreen(
                login = { usuario ->
                    viewModel.guardarUsuario(usuario)
                    navController.navigate(Screen.HomeScreen.route){
                        popUpTo(Screen.LoginScreen.route) { inclusive = true }
                    }
                }
            )
        }
        composable(route = Screen.AgregarTarjeta.route){
            AgregarTarjeta(
                viewModel = viewModel,
                volver = {
                    navController.navigateUp()
                }
            )
        }
    }
}