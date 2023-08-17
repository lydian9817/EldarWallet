package com.example.eldarwallet.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.eldarwallet.dominio.modelos.Tarjeta

@Database(entities = [Tarjeta::class], version = 1, exportSchema = false)
abstract class WalletDb : RoomDatabase() {
    abstract fun getDao(): WalletDao

    companion object {
        @Volatile
        private var InstanciaDeLaBd: WalletDb? = null

        fun getDb(context: Context): WalletDb{
            if (InstanciaDeLaBd!=null){
                return InstanciaDeLaBd as WalletDb
            } else{
                return synchronized(this){
                    Room.databaseBuilder(context, WalletDb::class.java, "WalletDb")
                        .build()
                        .also { InstanciaDeLaBd = it }
                }
            }
        }
    }



}