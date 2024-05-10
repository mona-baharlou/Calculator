package com.baharlou.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.baharlou.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onNumberClicked()
        onOperatorClicked()
    }


    private fun onNumberClicked() {

        binding.btnZero.setOnClickListener() {
            appendText("0")
        }

        binding.btnOne.setOnClickListener() {
            appendText("1")
        }

        binding.btnTwo.setOnClickListener() {
            appendText("2")
        }

        binding.btnThree.setOnClickListener() {
            appendText("3")
        }

        binding.btnFour.setOnClickListener() {
            appendText("4")
        }

        binding.btnFive.setOnClickListener() {
            appendText("5")
        }

        binding.btnSix.setOnClickListener() {
            appendText("6")
        }

        binding.btnSeven.setOnClickListener() {
            appendText("7")
        }

        binding.btnEight.setOnClickListener() {
            appendText("8")
        }

        binding.btnNine.setOnClickListener() {
            appendText("9")
        }

        binding.btnDot.setOnClickListener() {
            appendText(".")
        }
    }

    private fun appendText(text: String) {

    }

    private fun onOperatorClicked() {

        binding.btnJam.setOnClickListener() {
            appendText("+")
        }

        binding.btnMenha.setOnClickListener() {
            appendText("-")
        }

        binding.btnZarb.setOnClickListener() {
            appendText("*")
        }

        binding.btnTaqsim.setOnClickListener() {
            appendText("/")
        }

        binding.btnParantezBaz.setOnClickListener() {
            appendText("(")
        }

        binding.btnParantezBaste.setOnClickListener() {
            appendText(")")
        }

        binding.btnAc.setOnClickListener() {
            binding.txtExpression.text = ""
            binding.txtResult.text = ""
        }

        binding.btnDelete.setOnClickListener {

        }
    }


}