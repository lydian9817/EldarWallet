package com.example.eldarwallet.dominio.repositorios

import com.example.eldarwallet.dominio.modelos.Tarjeta
import kotlinx.coroutines.flow.Flow

interface WalletRepo {

    suspend fun agregarTarjeta(tarjeta: Tarjeta)

    suspend fun borrarTarjeta(tarjeta: Tarjeta)

    fun getTarjetas(): Flow<List<Tarjeta>>

    fun getTarjeta(numero: Long): Flow<Tarjeta>

}