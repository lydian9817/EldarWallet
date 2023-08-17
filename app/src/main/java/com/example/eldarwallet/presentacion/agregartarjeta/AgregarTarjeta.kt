package com.example.eldarwallet.presentacion.agregartarjeta

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import com.example.eldarwallet.dominio.modelos.Tarjeta
import com.example.eldarwallet.presentacion.MainViewModel

@Composable
fun AgregarTarjeta(
    viewModel: MainViewModel,
    volver: () -> Unit
) {
    var numero by remember { mutableStateOf("") }
    var codigo by remember { mutableStateOf("") }
    var vencimiento by remember { mutableStateOf("") }
    var nombreDelTitular by remember { mutableStateOf("") }
    var apellidoDelTitular by remember { mutableStateOf("") }
    val context = LocalContext.current
    Column{
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
        Button(onClick = {
            viewModel.agregarTarjeta(
                Tarjeta(
                    numero = numero.toLong(),
                    codigo = codigo.toInt(),
                    vencimiento = vencimiento,
                    marca = viewModel.seleccionarMarcaDeTarjeta(numero[0]),
                    nombreDelTitular = nombreDelTitular,
                    apellidoDelTitular = apellidoDelTitular
                ),
                context
            )
            volver()
        }
        ) {
            Text(text = "Agregar tarjeta")
        }
    }

}