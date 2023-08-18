package com.example.eldarwallet.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.eldarwallet.dominio.modelos.Tarjeta

@Database(entities = [Tarjeta::class], version = 1, exportSchema = false)
abstract class WalletDb : RoomDatabase() {
    abstract fun getDao(): WalletDao

}