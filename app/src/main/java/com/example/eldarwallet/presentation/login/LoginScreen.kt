package com.example.eldarwallet.presentation.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.eldarwallet.presentation.MainViewModel

@Composable
fun LoginScreen(
    login: () -> Unit,
    viewModel: MainViewModel
) {
    val state = viewModel.state
    var nombre by remember { mutableStateOf("") }
    var apellido by remember { mutableStateOf("") }

    Column() {
        Text(text = "Bienvenido a EldarWallet")
        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text(text = "Nombre") }
        )
        TextField(
            value = apellido,
            onValueChange = { apellido = it},
            label = { Text(text = "Apellido") }
        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = login) {
            Text(text = "Log in")
        }
    }
}