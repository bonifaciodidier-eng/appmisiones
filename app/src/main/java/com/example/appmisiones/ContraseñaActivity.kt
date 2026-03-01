package com.example.appmisiones

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener

class ContraseñaActivity : AppCompatActivity() {

    private val viewModel: ContraseñaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contrasena)

        val editContraseña = findViewById<EditText>(R.id.editContraseña)
        val txtFortaleza = findViewById<TextView>(R.id.txtFortaleza)

        editContraseña.addTextChangedListener { viewModel.verificarContraseña(it.toString()) }

        viewModel.fortaleza.observe(this, Observer { txtFortaleza.text = it })
    }
}