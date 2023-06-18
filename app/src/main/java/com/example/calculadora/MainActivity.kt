package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculadora.databinding.ActivityMainBinding
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalcular.setOnClickListener {
            val escolha: Int = binding.editEscolha.text.toString().toInt()
            val n1: Double = binding.editNumero1.text.toString().toDouble()
            val n2: Double = binding.editNumero2.text.toString().toDouble()
            var resultado: Double?=null

            when (escolha) {
                1 -> resultado = soma(n1, n2)
                2 -> resultado = subtracao(n1, n2)
                3 -> resultado = multiplicacao(n1, n2)
                4 -> resultado = divisao(n1, n2)
                5 -> resultado = Math.pow(n1, n2) //calcula a potência
                6 -> resultado = Math.sqrt(n1) //calcula a raiz quadrada
                7 -> resultado = Math.cbrt(n1) //calcula a raiz cúbica
                //6 -> resultado = Math.sqrt(n1) //calcula a raiz
            }
            binding.textResultado.text = "O resultado é " + resultado.toString()
        }
    }
}

private fun soma(numero1: Double, numero2: Double) = numero1 + numero2

private fun subtracao(numero1: Double, numero2: Double) = numero1 - numero2

private fun multiplicacao(numero1: Double, numero2: Double) = numero1 * numero2

private fun divisao(numero1: Double, numero2: Double) = numero1 / numero2

private fun potencia(numero1: Double, numero2: Double) = Math.pow(numero1, numero2)
//var result = Math.sqrt(number.toDouble())

fun calculate(n1: Double, n2: Double, operation: (Double, Double) -> Double): Double {
    val result = operation(n1, n2)
    return result
}