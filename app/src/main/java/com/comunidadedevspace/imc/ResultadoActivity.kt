package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val CHAVE_RESULTADO_IMC = "AcitivityResultado.CHAVE_IMC"

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val resultado = intent.getFloatExtra(CHAVE_RESULTADO_IMC, 0f)

        val resultadoImc = findViewById<TextView>(R.id.tv_resultado)
        val classificacaoImc = findViewById<TextView>(R.id.tv_classificao)

        resultadoImc.text = resultado.toString()

        val (classificacao, color) = when {
            resultado in 0f..18.5f -> Pair("MAGREZA", R.color.magreza)
            resultado in 18.5f..24.9f -> Pair("NORMAL", R.color.normal)
            resultado in 25.0f..29.9f -> Pair("SOBREPESO", R.color.sobrepeso)
            resultado in 30.0f..39.9f -> Pair("OBESIDADE", R.color.obesidade1)
            resultado >= 40.0f -> Pair("OBESIDADE GRAVE", R.color.obesidadegrave)
            else -> Pair("INVALIDO", R.color.white)
        }

        classificacaoImc.text = classificacao
        classificacaoImc.setTextColor(getColor(color))

    }
}