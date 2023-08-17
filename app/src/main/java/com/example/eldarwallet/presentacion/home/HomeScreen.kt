package com.example.eldarwallet.presentacion.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel

@Composable
fun HomeScreen(
    irAAgregarTarjeta: () -> Unit,
    viewModel: ViewModel
) {
    Column() {
        Text(text = "Saldo actual")
        Text(text = "$4000")
        Text(text = "Tarjetas asociadas")
        LazyRow(){
            
        }

        Button(onClick = irAAgregarTarjeta) {
            Text(text = "Agregar tarjeta")
        }
    }
}
