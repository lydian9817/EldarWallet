package com.example.eldarwallet.presentacion
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eldarwallet.dominio.modelos.Tarjeta
import com.example.eldarwallet.dominio.modelos.Usuario
import com.example.eldarwallet.dominio.repositorios.WalletRepo
import com.example.eldarwallet.presentacion.detalle.EstadoDetalle
import com.example.eldarwallet.presentacion.home.EstadoHome
import com.example.eldarwallet.util.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.InputStream
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: WalletRepo
) : ViewModel(){

    val estado: StateFlow<EstadoHome> =
        repo.getTarjetas().map { EstadoHome(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(),
                initialValue = EstadoHome()
            )
    lateinit var detalle: StateFlow<EstadoDetalle>
    private val _estadoImagen = MutableStateFlow<InputStream?>(null)
    val estadoImagen: StateFlow<InputStream?> = _estadoImagen
    private lateinit var usuarioActual: Usuario
    private var numeroDeTarjetaActual = ""

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

    fun getTarjeta() {
        detalle = repo.getTarjeta(numeroDeTarjetaActual).map { EstadoDetalle(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(),
                initialValue = EstadoDetalle()
            )
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

    fun generarQr() {
        val client = OkHttpClient()

        val mediaType = "application/x-www-form-urlencoded".toMediaTypeOrNull()
        val body =
            "content=${usuarioActual.nombre} ${usuarioActual.apellido}".toRequestBody(mediaType)
            val request = Request.Builder()
            .url(URL)
            .post(body)
            .addHeader("content-type", "application/x-www-form-urlencoded")
            .addHeader("X-RapidAPI-Key", QR_API_KEY)
            .addHeader("X-RapidAPI-Host", QR_API_HOST)
            .build()
            viewModelScope.launch(Dispatchers.IO){
               val respuesta = client.newCall(request).execute()
                _estadoImagen.value = respuesta.body?.byteStream()
            }
    }
    fun encriptar(valor: String, clave: String): String{
        val texto = valor.toByteArray()
        val claveSecreta = SecretKeySpec(clave.toByteArray(), "AES")
        val cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING")
        cipher.init(Cipher.ENCRYPT_MODE, claveSecreta)
        val textoEncriptado = cipher.doFinal(texto)
        return textoEncriptado.toString()
    }
    fun decifrar(valor: String, clave: String): String{
        val texto = valor.toByteArray()
        val claveSecreta = SecretKeySpec(clave.toByteArray(), "AES")
        val cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING")
        cipher.init(Cipher.DECRYPT_MODE, claveSecreta)
        val textoEncriptado = cipher.doFinal(texto)
        return textoEncriptado.toString()
    }
    fun guardarUsuario(usuario: Usuario){
        usuarioActual = usuario
    }
    fun guardarNumeroDeTarjeta(numero: String){
        numeroDeTarjetaActual = numero
    }
}