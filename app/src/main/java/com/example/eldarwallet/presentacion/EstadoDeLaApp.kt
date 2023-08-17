package com.example.eldarwallet.presentacion

import com.example.eldarwallet.dominio.modelos.Tarjeta

data class EstadoDeLaApp(
    val tarjetas: List<Tarjeta> = emptyList()
)
