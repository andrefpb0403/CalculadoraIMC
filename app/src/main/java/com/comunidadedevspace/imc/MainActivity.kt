package com.comunidadedevspace.imc

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtPeso = findViewById<TextInputEditText>(R.id.edt_peso)
        val edtAltura = findViewById<TextInputEditText>(R.id.edt_altura)

        val calcular = findViewById<Button>(R.id.btn_calcular)

        calcular.setOnClickListener {

            val pesoStr: String = edtPeso.text.toString()
            val alturaStr: String = edtAltura.text.toString()

            if (pesoStr == "" || alturaStr == "") {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT)
                    .show()
            } else {

                val peso = pesoStr.toFloat()
                val altura = alturaStr.toFloat()

                val resultado = peso / (altura * altura)
                println("Seu IMC é de: $resultado")

                val telaResultado = Intent(this, ResultadoActivity::class.java)
                val intent = Intent(this, ResultadoActivity::class.java)
                intent.putExtra(CHAVE_RESULTADO_IMC, resultado)
                startActivity(intent)
            }

        }

    }
}