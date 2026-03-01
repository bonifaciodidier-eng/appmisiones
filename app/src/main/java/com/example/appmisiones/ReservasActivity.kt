package com.example.appmisiones

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import android.widget.Button
import android.widget.TextView

class ReservasActivity : AppCompatActivity() {

    private val viewModel: ReservasViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservas)

        val txtCupos = findViewById<TextView>(R.id.txtCupos)
        val btnReservar = findViewById<Button>(R.id.btnReservar)

        btnReservar.setOnClickListener { viewModel.reservarCupo() }

        viewModel.cuposDisponibles.observe(this, Observer { txtCupos.text = "Cupos: $it" })
        viewModel.botonHabilitado.observe(this, Observer { btnReservar.isEnabled = it })
    }
}