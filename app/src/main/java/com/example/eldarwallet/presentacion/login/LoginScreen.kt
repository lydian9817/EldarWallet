package com.example.eldarwallet.presentacion.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.eldarwallet.dominio.modelos.Usuario

@Composable
fun LoginScreen(
    login: (Usuario) -> Unit,
) {
    var nombre by remember { mutableStateOf("") }
    var apellido by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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
        Button(onClick = { login(Usuario(nombre, apellido)) }) {
            Text(text = "Log in")
        }
    }
}