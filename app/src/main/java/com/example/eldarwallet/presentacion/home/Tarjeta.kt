package com.example.eldarwallet.presentacion.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Tarjeta(
    numero: Long,
    marca: String,
    nombreDelTitular: String,
    apellidoDelTitular: String,
    borrarTarjeta: () -> Unit
) {
    Card() {
        Text(text = marca)
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = numero.toString())
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = "$nombreDelTitular $apellidoDelTitular")
        Button(onClick = borrarTarjeta) {
            Text(text = "Borrar tarjeta")
        }
    }
}