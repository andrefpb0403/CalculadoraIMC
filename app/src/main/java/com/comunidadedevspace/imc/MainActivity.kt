package com.comunidadedevspace.imc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Recuperar os componentes EditText
        //Criar uma variável e associar o componente TextInputEditText
        //Recuperar botao

        val peso = findViewById<TextInputEditText>(R.id.edt_peso)
        val altura = findViewById<TextInputEditText>(R.id.edt_altura)
        val calcular = findViewById<Button>(R.id.btn_calcular)

        calcular.setOnClickListener {
            val peso = peso.text
            val altura = altura.text

            println("Seu peso e sua altura são: $peso e $altura")
        }
    }
}