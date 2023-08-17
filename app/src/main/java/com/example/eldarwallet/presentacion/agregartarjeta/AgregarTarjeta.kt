package com.example.eldarwallet.presentacion.agregartarjeta

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import com.example.eldarwallet.presentacion.MainViewModel

@Composable
fun AgregarTarjeta(
    viewModel: MainViewModel
) {
    var numero by remember { mutableStateOf("") }
    var codigo by remember { mutableStateOf("") }
    var vencimiento by remember { mutableStateOf("") }
    var nombreDelTitular by remember { mutableStateOf("") }
    var apellidoDelTitular by remember { mutableStateOf("") }

    Text(text = "Ingrese los datos de la tarjeta")
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
    TextField(
        value = nombreDelTitular,
        onValueChange = { nombreDelTitular = it },
        label = { Text(text = "Nombre del titular") }
    )
    TextField(
        value = apellidoDelTitular,
        onValueChange = { apellidoDelTitular = it },
        label = { Text(text = "Apellido del titular") }
    )
    Button(onClick = { /*TODO*/ }) {
        Text(text = "Agregar tarjeta")
    }
}