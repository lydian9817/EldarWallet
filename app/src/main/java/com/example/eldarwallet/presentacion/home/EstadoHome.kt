package com.example.eldarwallet.presentacion.home

import com.example.eldarwallet.dominio.modelos.Tarjeta

data class EstadoHome(
    val tarjetas: List<Tarjeta> = emptyList()
)
