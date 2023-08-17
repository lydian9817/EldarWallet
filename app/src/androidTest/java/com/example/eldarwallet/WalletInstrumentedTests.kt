package com.example.eldarwallet

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.eldarwallet.data.WalletDao
import com.example.eldarwallet.data.WalletDb
import com.example.eldarwallet.dominio.modelos.Tarjeta
import com.example.eldarwallet.util.AMEX
import com.example.eldarwallet.util.MASTERCARD
import com.example.eldarwallet.util.VISA
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import java.io.IOException

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class WalletDaoTest {

    private lateinit var walletDao: WalletDao
    private lateinit var walletDb: WalletDb
    private val numeroDeTarjeta1 = "375492985"
    private val numeroDeTarjeta2 = "42943785492"
    private var tarjetaDePrueba1 = Tarjeta(
        numeroDeTarjeta1.toLong(),
        123,
        "1/25",
        seleccionarMarcaDeTarjeta(numeroDeTarjeta1[0]),
        "Mauri",
        "Caricari"
    )
    private var tarjetaDePrueba2 = Tarjeta(
        numeroDeTarjeta2.toLong(),
        123,
        "1/25",
        seleccionarMarcaDeTarjeta(numeroDeTarjeta2[0]),
        "Lionel",
        "Messi"
    )

    @Before
    fun crearDb(){
        val context: Context = ApplicationProvider.getApplicationContext()
        walletDb = Room.inMemoryDatabaseBuilder(context, WalletDb::class.java)
            .allowMainThreadQueries() //para testing
            .build()
        walletDao = walletDb.getDao()
    }

    @After
    @Throws(IOException::class)
    fun cerrarDb(){
        walletDb.close()
    }

    @Test
    @Throws(Exception::class)
    fun agregarTarjetasALaDb() = runBlocking {
        agregarTarjetas()
        val tarjetas = walletDao.getTarjetas().first()
        assertEquals(tarjetas[0], tarjetaDePrueba1)

    }

    @Test
    @Throws(Exception::class)
    fun eliminarTarjetaDeLaDb() = runBlocking {
        agregarTarjetas()
        eliminarTarjeta(tarjetaDePrueba1)
        val tarjetas = walletDao.getTarjetas().first()
        assertNotEquals(tarjetas[0], tarjetaDePrueba1)

    }

    private fun seleccionarMarcaDeTarjeta(primerNumero: Char): String {
        var marca = ""
        when(primerNumero){
            '3' -> marca = AMEX
            '4' -> marca = VISA
            '5' -> marca = MASTERCARD
        }
        return marca
    }

    private suspend fun agregarTarjetas(){
        walletDao.agregarTarjeta(tarjetaDePrueba1)
        walletDao.agregarTarjeta(tarjetaDePrueba2)
    }

    private suspend fun eliminarTarjeta(tarjeta: Tarjeta){
        walletDao.borrarTarjeta(tarjeta)
    }
}