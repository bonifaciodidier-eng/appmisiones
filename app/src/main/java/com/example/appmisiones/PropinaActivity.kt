package com.example.appmisiones

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class PropinaActivity : AppCompatActivity() {

    private val viewModel: PropinaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_propina)

        val editMonto = findViewById<EditText>(R.id.editMonto)
        val btnBueno = findViewById<Button>(R.id.btnBueno)
        val btnRegular = findViewById<Button>(R.id.btnRegular)
        val btnMalo = findViewById<Button>(R.id.btnMalo)
        val txtPropina = findViewById<TextView>(R.id.txtPropina)
        val txtTotal = findViewById<TextView>(R.id.txtTotal)

        fun monto() = editMonto.text.toString().toDoubleOrNull() ?: 0.0

        btnBueno.setOnClickListener { viewModel.calcularPropina(monto(), "Bueno") }
        btnRegular.setOnClickListener { viewModel.calcularPropina(monto(), "Regular") }
        btnMalo.setOnClickListener { viewModel.calcularPropina(monto(), "Malo") }

        viewModel.propina.observe(this, Observer { txtPropina.text = "Propina: $it" })
        viewModel.total.observe(this, Observer { txtTotal.text = "Total: $it" })
    }
}