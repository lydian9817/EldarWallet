package com.example.eldarwallet.di

import android.content.Context
import androidx.room.Room
import com.example.eldarwallet.data.WalletDb
import com.example.eldarwallet.data.WalletRepoImpl
import com.example.eldarwallet.dominio.repositorios.WalletRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideRoom(@ApplicationContext context: Context)
        = Room.databaseBuilder(context, WalletDb::class.java, "WalletDb").build()

    @Provides
    @Singleton
    fun provideWalletRepo(db: WalletDb): WalletRepo{
        return WalletRepoImpl(db.getDao())
    }
}