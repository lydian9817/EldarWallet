package com.example.eldarwallet.presentacion.home

import androidx.compose.foundation.layout.*
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
    borrarTarjeta: () -> Unit,
    borrable: Boolean = true
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Column(modifier = Modifier.padding(start = 4.dp)) {
            Text(text = marca)
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = numero.toString())
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "$nombreDelTitular $apellidoDelTitular")
            if(borrable) {
                TextButton(onClick = borrarTarjeta) {
                    Text(text = "Borrar tarjeta")
                }
            }
        }

    }
}