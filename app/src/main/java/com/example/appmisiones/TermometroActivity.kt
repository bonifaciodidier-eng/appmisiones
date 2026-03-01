package com.example.appmisiones

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class TermometroActivity : AppCompatActivity() {

    private val viewModel: TermometroViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)  
        setContentView(R.layout.activity_termometro)

        val editTemperatura = findViewById<EditText>(R.id.editTemperatura)
        val btnVerificar = findViewById<Button>(R.id.btnVerificar)
        val txtEstado = findViewById<TextView>(R.id.txtEstado)

        btnVerificar.setOnClickListener {
            val temp = editTemperatura.text.toString().toIntOrNull() ?: 0
            viewModel.verificarTemperatura(temp)
        }

        viewModel.estado.observe(this, Observer { txtEstado.text = it })
        viewModel.color.observe(this, Observer { txtEstado.setTextColor(it) })
    }
}