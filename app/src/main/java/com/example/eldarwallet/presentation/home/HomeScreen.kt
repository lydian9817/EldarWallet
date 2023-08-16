package com.example.eldarwallet.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen(
    irAAgregarTarjeta: () -> Unit
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
