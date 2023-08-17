package com.example.eldarwallet.presentacion
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eldarwallet.dominio.modelos.Tarjeta
import com.example.eldarwallet.dominio.modelos.Usuario
import com.example.eldarwallet.dominio.repositorios.WalletRepo
import com.example.eldarwallet.util.AMEX
import com.example.eldarwallet.util.MASTERCARD
import com.example.eldarwallet.util.VISA
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: WalletRepo
) : ViewModel(){

    //private val _estado = mutableStateOf(EstadoDeLaApp())
    val estado: StateFlow<EstadoDeLaApp> =
        repo.getTarjetas().map { EstadoDeLaApp(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(),
                initialValue = EstadoDeLaApp()
            )
    private lateinit var usuarioActual: Usuario


    fun agregarTarjeta(tarjeta: Tarjeta, context: Context){
        viewModelScope.launch {
            if(tarjeta.apellidoDelTitular == usuarioActual.apellido
                && tarjeta.nombreDelTitular == usuarioActual.nombre) {
                repo.agregarTarjeta(tarjeta)
                Toast.makeText(context, "Tarjeta Agregada", Toast.LENGTH_SHORT).show()
            } else{
                Toast.makeText(context, "Error. No es el titular", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun borrarTarjeta(tarjeta: Tarjeta){
        viewModelScope.launch {
            repo.borrarTarjeta(tarjeta)
        }
    }

    fun seleccionarMarcaDeTarjeta(primerNumero: Char): String {
        var marca = ""
        when(primerNumero){
            '3' -> marca = AMEX
            '4' -> marca = VISA
            '5' -> marca = MASTERCARD
        }
        return marca
    }

    fun guardarUsuario(usuario: Usuario){
        usuarioActual = usuario
    }
}