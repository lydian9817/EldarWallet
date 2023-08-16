package com.example.eldarwallet.data

import androidx.room.*
import androidx.room.Dao
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun agregarUsuario(usuario: Usuario)

    @Update
    suspend fun actualizarDatosDeUsuario(usuario: Usuario)

    @Query("SELECT * from usuario WHERE nombre = :nombre AND apellido = :apellido")
    fun getUsuario(nombre: String, apellido: String): Flow<Usuario>
}