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


        // Recuperar os componentes EditText
        //Criar uma variável e associar o componente TextInputEditText
        //Recuperar botao

        val peso = findViewById<TextInputEditText>(R.id.edt_peso)
        val altura = findViewById<TextInputEditText>(R.id.edt_altura)


        val calcular = findViewById<Button>(R.id.btn_calcular)

        calcular.setOnClickListener {

            val pesoStr: String = peso.text.toString()
            val alturaStr: String = altura.text.toString()

            if (pesoStr == "" || alturaStr == "") {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT)
                    .show()
            } else {

                val peso = pesoStr.toFloat()
                val altura = alturaStr.toFloat()

                val resultado = peso / (altura * altura)
                println("Seu IMC é de: $resultado")

                 /*
                 * MENO QUE 18,5 MAGREZA
                 * ENTRE 18,5 E 24,9 NORMAL
                 * ENTRE 25,0 E 29,9 SOBREPESO I
                 * ENTRE 30,0 E 39,9 OBESIDADE II
                 * MAIOR QUE 40,0    OBESIDADE GRAVE
                 * */

                if (resultado < 18.5) {
                    println("Você está abaixo do peso")
                } else if (resultado in 18.5..24.9) {
                    println("Você está no peso normal")
                } else if (resultado in 25.0..29.9) {
                    println("Você está com sobrepeso")
                } else if (resultado in 30.0..39.9) {
                    println("Você está com obesidade")
                } else {
                    println("Você está com obesidade grave")
                }

                val telaResultado = Intent(this, ResultadoActivity::class.java)
                val intent = Intent(this, ResultadoActivity::class.java)
                startActivity(intent)
            }





        }


    }
}