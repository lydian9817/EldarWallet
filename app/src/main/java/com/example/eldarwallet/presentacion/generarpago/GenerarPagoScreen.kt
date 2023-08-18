package com.example.eldarwallet.presentacion.generarpago

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.eldarwallet.presentacion.MainViewModel
import com.example.eldarwallet.presentacion.home.Tarjeta
import com.example.eldarwallet.util.Claves

@Composable
fun GenerarPagoScreen(
    viewModel: MainViewModel,
    confirmarPago: (String) -> Unit
) {
    val estado by viewModel.estado.collectAsState()
    var numeroDeTarjetaSeleccionada by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Seleccionar tarjeta", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(10.dp))
        LazyColumn(){
            items(estado.tarjetas){tarjeta ->
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .clickable {
                            numeroDeTarjetaSeleccionada = tarjeta.numero
                            confirmarPago(numeroDeTarjetaSeleccionada)
                        }
                ) {
                    Tarjeta(
                        numero = viewModel.decifrar(tarjeta.numero, Claves.NUMERO),
                        marca = viewModel.decifrar(tarjeta.marca, Claves.MARCA),
                        nombreDelTitular = tarjeta.nombreDelTitular,
                        apellidoDelTitular = tarjeta.apellidoDelTitular,
                        borrarTarjeta = { viewModel.borrarTarjeta(tarjeta) },
                        borrable = false
                    )
                }
            }
        }
    }
}