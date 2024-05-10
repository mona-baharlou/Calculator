package com.baharlou.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewTreeObserver
import android.widget.Toast
import com.baharlou.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private var operator: Char = '+'

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onNumberClicked()
        onOperatorClicked()
    }


    private fun onNumberClicked() {

        binding.btnZero.setOnClickListener() {

            if (binding.txtExpression.text.isNotEmpty())
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

            if (binding.txtExpression.text.isEmpty()) {
                appendText("0.")
            } else if (!binding.txtExpression.text.contains("."))
                appendText(".")
        }
    }

    private fun appendText(newText: String) {

        if (binding.txtResult.text.isNotEmpty()) {
            binding.txtExpression.text = ""
        }

        binding.txtResult.text = ""

        binding.txtExpression.append(newText)


        val viewTree: ViewTreeObserver = binding.horizontalScrollViewTxtExpression.viewTreeObserver
        viewTree.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                binding.horizontalScrollViewTxtExpression.viewTreeObserver.removeOnGlobalLayoutListener(
                    this
                )

                binding.horizontalScrollViewTxtExpression.scrollTo(binding.txtExpression.width, 0)
            }

        })

        val viewTreeResult: ViewTreeObserver =
            binding.horizontalScrollViewTxtResult.viewTreeObserver
        viewTreeResult.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                binding.horizontalScrollViewTxtResult.viewTreeObserver.removeOnGlobalLayoutListener(
                    this
                )

                binding.horizontalScrollViewTxtResult.scrollTo(binding.txtResult.width, 0)
            }

        })

    }

    private fun onOperatorClicked() {

        binding.btnSum.setOnClickListener() {
            if (binding.txtExpression.text.isNotEmpty()) {
                val myChar = binding.txtExpression.text.last()

                if (myChar != '+' &&
                    myChar != '-' &&
                    myChar != '*' &&
                    myChar != '/'
                )
                    appendText("+")
            }
        }

        binding.btnMinus.setOnClickListener() {
            if (binding.txtExpression.text.isNotEmpty()) {

                val myChar = binding.txtExpression.text.last()

                if (myChar != '+' &&
                    myChar != '-' &&
                    myChar != '*' &&
                    myChar != '/'
                )
                    appendText("-")
            }
        }

        binding.btnMultiplection.setOnClickListener() {
            if (binding.txtExpression.text.isNotEmpty()) {

                val myChar = binding.txtExpression.text.last()

                if (myChar != '+' &&
                    myChar != '-' &&
                    myChar != '*' &&
                    myChar != '/'
                )
                    appendText("*")
            }
        }

        binding.btnDivision.setOnClickListener() {
            if (binding.txtExpression.text.isNotEmpty()) {

                val myChar = binding.txtExpression.text.last()

                if (myChar != '+' &&
                    myChar != '-' &&
                    myChar != '*' &&
                    myChar != '/'
                )
                    appendText("/")
            }
        }

        binding.btnClosedParantez.setOnClickListener() {
            appendText("(")
        }

        binding.btnOpenParantez.setOnClickListener() {
            appendText(")")
        }

        binding.btnAc.setOnClickListener() {
            binding.txtExpression.text = ""
            binding.txtResult.text = ""
        }

        binding.btnDelete.setOnClickListener {

            val oldText = binding.txtExpression.text.toString()

            if (oldText.isNotEmpty()) {
                binding.txtExpression.text = oldText.substring(0, oldText.length - 1)
            }
        }

        binding.btnEqual.setOnClickListener() {

            try {
                val expression = ExpressionBuilder(binding.txtExpression.text.toString()).build()
                val result = expression.evaluate()

                val longResult = result.toLong()

                //135.0 == 135
                if (result == longResult.toDouble()) {
                    binding.txtResult.text = longResult.toString()
                } else {
                    binding.txtResult.text = result.toString()
                }
            } catch (ex: Exception) {
                binding.txtResult.text = ""
                binding.txtExpression.text = ""

                Toast.makeText(this, "Error Occurred !", Toast.LENGTH_LONG).show()
            }
        }
    }


}