package com.example.eldarwallet.presentacion
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){

    private val _state = mutableStateOf(AppState())
    val state: State<AppState> = _state

    fun actualizarNombre(value: String) {
        _state.value = state.value.copy(
            nombre = value
        )
    }
    fun actualizarApellido(value: String) {
        _state.value = state.value.copy(
            apellido = value
        )
    }
}