package com.example.eldarwallet.presentacion.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.eldarwallet.presentacion.MainViewModel

@Composable
fun HomeScreen(
    irAAgregarTarjeta: () -> Unit,
    irAPagoConQr: () -> Unit,
    irAGenerarPago: () -> Unit,
    viewModel: MainViewModel,
) {
    val estado by viewModel.estado.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Saldo actual: $4000")
        Text(text = "Tarjetas asociadas")
        LazyRow(){
            items(estado.tarjetas){tarjeta ->

                Tarjeta(
                    numero = tarjeta.numero,
                    marca = tarjeta.marca,
                    nombreDelTitular = tarjeta.nombreDelTitular,
                    apellidoDelTitular = tarjeta.apellidoDelTitular,
                    borrarTarjeta = { viewModel.borrarTarjeta(tarjeta) }
                )
            }
        }

        Button(onClick = irAAgregarTarjeta) {
            Text(text = "Agregar tarjeta")
        }
        Button(onClick = irAPagoConQr) {
            Text(text = "Pagar con QR")
        }
        Button(onClick = irAGenerarPago) {
            Text(text = "Generar pago")
        }
    }
}
