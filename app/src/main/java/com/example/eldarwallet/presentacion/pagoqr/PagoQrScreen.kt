package com.example.eldarwallet.presentacion.pagoqr

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.eldarwallet.presentacion.MainViewModel

@Composable
fun PagoQrScreen(
    viewModel: MainViewModel
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        val imagenStream by viewModel.estadoImagen.collectAsState()
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imagenStream)
                .build(),
            contentDescription = ""
        )
    }
}