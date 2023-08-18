package com.example.eldarwallet.data

import com.example.eldarwallet.dominio.modelos.Tarjeta
import com.example.eldarwallet.dominio.repositorios.WalletRepo
import kotlinx.coroutines.flow.Flow

class WalletRepoImpl(private val walletDao: WalletDao) : WalletRepo {

    override suspend fun agregarTarjeta(tarjeta: Tarjeta) = walletDao.agregarTarjeta(tarjeta)

    override suspend fun borrarTarjeta(tarjeta: Tarjeta) = walletDao.borrarTarjeta(tarjeta)

    override fun getTarjetas(): Flow<List<Tarjeta>> = walletDao.getTarjetas()

    override fun getTarjeta(numero: String): Flow<Tarjeta> = walletDao.getTarjeta(numero)

}