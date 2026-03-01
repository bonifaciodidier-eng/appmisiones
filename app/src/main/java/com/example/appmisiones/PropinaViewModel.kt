package com.example.appmisiones

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PropinaViewModel : ViewModel() {

    private val _propina = MutableLiveData<Double>()
    val propina: LiveData<Double> = _propina

    private val _total = MutableLiveData<Double>()
    val total: LiveData<Double> = _total

    fun calcularPropina(monto: Double, nivelServicio: String) {
        val porcentaje = when(nivelServicio) {
            "Bueno" -> 0.15
            "Regular" -> 0.10
            "Malo" -> 0.05
            else -> 0.0
        }
        _propina.value = monto * porcentaje
        _total.value = monto + (_propina.value ?: 0.0)
    }
}