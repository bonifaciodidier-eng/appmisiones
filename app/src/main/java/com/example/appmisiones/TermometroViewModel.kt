package com.example.appmisiones

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.graphics.Color

class TermometroViewModel : ViewModel() {

    private val _estado = MutableLiveData<String>()
    val estado: LiveData<String> = _estado

    private val _color = MutableLiveData<Int>()
    val color: LiveData<Int> = _color

    fun verificarTemperatura(temperatura: Int) {
        if (temperatura <= 80) {
            _estado.value = "Normal"
            _color.value = Color.BLUE
        } else {
            _estado.value = "Alerta: Sobrecalentamiento"
            _color.value = Color.RED
        }
    }
}