package com.example.appmisiones

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContraseñaViewModel : ViewModel() {

    private val _fortaleza = MutableLiveData<String>()
    val fortaleza: LiveData<String> = _fortaleza

    fun verificarContraseña(pass: String) {
        _fortaleza.value = when {
            pass.length < 5 -> "Corta"
            pass.length in 5..10 -> "Media"
            else -> "Fuerte"
        }
    }
}