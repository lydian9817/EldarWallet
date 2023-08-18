package com.example.eldarwallet.presentacion.login

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
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
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Bienvenido a EldarWallet", style = MaterialTheme.typography.headlineSmall)
        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text(text = "Nombre") },
            singleLine = true
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = apellido,
            onValueChange = { apellido = it},
            label = { Text(text = "Apellido") },
            singleLine = true
        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { login(Usuario(nombre, apellido)) }) {
            Text(text = "Log in")
        }
    }
}