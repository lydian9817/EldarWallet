package com.example.eldarwallet.presentacion.pagoqr

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp
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
        val imagenStream = viewModel.respuestaQr.body?.byteStream()
        val imagenBitmap = BitmapFactory.decodeStream(imagenStream).asImageBitmap()
        Image(
            bitmap = imagenBitmap,
            contentDescription = ""
        )
    }

}