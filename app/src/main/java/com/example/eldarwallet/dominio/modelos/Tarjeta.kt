package com.example.eldarwallet.dominio.modelos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tarjeta")
data class Tarjeta(
    @PrimaryKey val numero: Long,
    val codigo: Int,
    val vencimiento: String,
    val marca: String,
    val nombreDelTitular: String,
    val apellidoDelTitular: String
)