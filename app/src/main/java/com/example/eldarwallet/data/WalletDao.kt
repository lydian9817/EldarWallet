package com.example.eldarwallet.data

import androidx.room.*
import androidx.room.Dao
import com.example.eldarwallet.dominio.modelos.Tarjeta
import kotlinx.coroutines.flow.Flow

@Dao
interface WalletDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun agregarTarjeta(tarjeta: Tarjeta)
    @Delete
    suspend fun borrarTarjeta(tarjeta: Tarjeta)
    @Query("SELECT * from tarjeta ORDER BY numero ASC")
    fun getTarjetas(): Flow<List<Tarjeta>>
}