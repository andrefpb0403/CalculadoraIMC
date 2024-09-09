package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

//Pensando na intent como um pacote que vai ser entregue, e esse pacote tem uma senha (chave) é recomendados
//que essa chave seja guardada em algum lugar, a sintaxe abaixo serve para isso. Para guardar a chave dentro de uma variável
const val CHAVE_RESULTADO_IMC = "AcitivityResultado.CHAVE_IMC"
const val CHAVE_RESULTADO_CLASSIFICACAO = "AcitivityResultado.CHAVE_IMC"

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

        /*
        * MENO QUE 18,5 MAGREZA
        * ENTRE 18,5 E 24,9 NORMAL
        * ENTRE 25,0 E 29,9 SOBREPESO I
        * ENTRE 30,0 E 39,9 OBESIDADE II
        * MAIOR QUE 40,0    OBESIDADE GRAVE
        * */

        //Sintaxe abaixo é utilizada para enquadrar o resultado do IMC e mostrar ao usuário.
        val classificacao: String = if (resultado <= 18.5) {
            "Você está abaixo do peso"
        } else if (resultado in 18.5..24.9) {
            "Você está no peso normal"
        } else if (resultado in 25.0..29.9) {
            "Você está com sobrepeso"
        } else if (resultado in 30.0..39.9) {
            "Você está com obesidade"
        } else {
            "Você está com obesidade grave"
        }

        classificacaoImc.text = classificacao

    }
}