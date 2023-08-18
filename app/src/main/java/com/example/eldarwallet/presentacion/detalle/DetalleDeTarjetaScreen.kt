package com.example.eldarwallet.presentacion.detalle

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.eldarwallet.presentacion.MainViewModel
import com.example.eldarwallet.util.Claves

@Composable
fun DetalleDeTarjetaScreen(
    viewModel: MainViewModel
) {
    val tarjetaSeleccionada by viewModel.detalle.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Tarjeta seleccionada")
        Row{
            Text(text = "Marca: ")
            tarjetaSeleccionada.tarjeta?.let { Text(text = viewModel.decifrar(it.marca, Claves.MARCA)) }
        }
        Row{
            Text(text = "Numero: ")
            tarjetaSeleccionada.tarjeta?.let { Text(text = viewModel.decifrar(it.numero, Claves.NUMERO)) }
        }
        Row{
            Text(text = "Vencimiento: ")
            tarjetaSeleccionada.tarjeta?.let { Text(text = viewModel.decifrar(it.vencimiento, Claves.VENCIMIENTO)) }
        }
        Row{
            Text(text = "Nombre: ")
            tarjetaSeleccionada.tarjeta?.let { Text(text = it.nombreDelTitular) }
        }
        Row{
            Text(text = "Apellido: ")
            tarjetaSeleccionada.tarjeta?.let { Text(text = it.apellidoDelTitular) }
        }
    }
}