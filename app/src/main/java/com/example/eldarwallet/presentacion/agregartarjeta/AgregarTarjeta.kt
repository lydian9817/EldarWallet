package com.example.eldarwallet.presentacion.agregartarjeta

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.eldarwallet.dominio.modelos.Tarjeta
import com.example.eldarwallet.presentacion.MainViewModel
import com.example.eldarwallet.util.Claves

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
    Column(
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ){
        Text(text = "Ingrese los datos de la tarjeta", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(4.dp))
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = numero,
            onValueChange = { numero = it },
            label = { Text(text = "Número de tarjeta") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            singleLine = true
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = codigo,
            onValueChange = { codigo = it },
            label = { Text(text = "Código de seguridad") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            singleLine = true
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = vencimiento,
            onValueChange = { vencimiento = it },
            label = { Text(text = "Fecha de vencimiento") },
            singleLine = true
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = nombreDelTitular,
            onValueChange = { nombreDelTitular = it },
            label = { Text(text = "Nombre del titular") },
            singleLine = true
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = apellidoDelTitular,
            onValueChange = { apellidoDelTitular = it },
            label = { Text(text = "Apellido del titular") },
            singleLine = true
        )
        Button(onClick = {
            viewModel.agregarTarjeta(
                Tarjeta(
                    numero = viewModel.encriptar(numero, Claves.NUMERO),
                    codigo = viewModel.encriptar(codigo, Claves.CODIGO),
                    vencimiento = viewModel.encriptar(vencimiento, Claves.VENCIMIENTO),
                    marca = viewModel.encriptar(
                        viewModel.seleccionarMarcaDeTarjeta(numero[0]
                        ), Claves.MARCA),
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