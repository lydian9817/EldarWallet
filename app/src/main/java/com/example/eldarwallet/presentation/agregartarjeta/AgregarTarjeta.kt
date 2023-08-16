package com.example.eldarwallet.presentation.agregartarjeta

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import com.example.eldarwallet.presentation.MainViewModel

@Composable
fun AgregarTarjeta(
    viewModel: MainViewModel
) {
    var numero by remember { mutableStateOf("") }
    var codigo by remember { mutableStateOf("") }
    var vencimiento by remember { mutableStateOf("") }
    
    Text(text = "Numero de tarjeta")
    TextField(
        value = numero, 
        onValueChange = { numero = it },
        label = { Text(text = "Número de tarjeta") }
    )
    TextField(
        value = codigo, 
        onValueChange = { codigo = it },
        label = { Text(text = "Código de seguridad") }
    )
    TextField(
        value = vencimiento, 
        onValueChange = { vencimiento = it },
        label = { Text(text = "Fecha de vencimiento") }
    )
    Button(onClick = { /*TODO*/ }) {
        Text(text = "Agregar tarjeta")
    }
}