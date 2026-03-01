package com.example.appmisiones

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ReservasViewModel : ViewModel() {

    private val _cuposDisponibles = MutableLiveData<Int>(20)
    val cuposDisponibles: LiveData<Int> = _cuposDisponibles

    private val _botonHabilitado = MutableLiveData<Boolean>(true)
    val botonHabilitado: LiveData<Boolean> = _botonHabilitado

    fun reservarCupo() {
        val nuevosCupos = (_cuposDisponibles.value ?: 0) - 1
        _cuposDisponibles.value = nuevosCupos
        if (nuevosCupos <= 0) _botonHabilitado.value = false
    }
}