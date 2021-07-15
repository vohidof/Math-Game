package com.example.mathgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_savol.*
import java.lang.Exception
import java.util.*

class Savol : AppCompatActivity() {

    var number1 = 0
    var number2 = 0
    var sign = 0
    var javob = 0
    var quizNumber = 0
    var name: String? = null
    var quizLiveNumber = 0
    var rightAns = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_savol)
        quizNumber = intent.getStringExtra("misolSoni")!!.toInt()
        name = intent.getStringExtra("name")
        random()

        btn_next.setOnClickListener {
            if (quizNumber > quizLiveNumber) {
                quizLiveNumber++
                val edtJavob = edt_javob.text.toString().toInt()
                if (javob == edtJavob) {
                    rightAns++
                    Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show()
                }
                edt_javob.text.clear()
                random()
            }

            if (quizNumber == quizLiveNumber) {
                btn_next.isEnabled = false
                Toast.makeText(
                    this,
                    "$name, you found $rightAns out of $quizNumber",
                    Toast.LENGTH_LONG
                ).show()
                txt_misol.text = "$name, you found $rightAns out of $quizNumber"
            }
        }
    }

    fun random() {
        number1 = Random().nextInt(20)
        number2 = Random().nextInt(20)
        sign = Random().nextInt(4)
        var quiz = ""

        when (sign) {
            0 -> {
                quiz = "$number1 + $number2 = "
                txt_misol.text = quiz
                javob = number1 + number2
            }
            1 -> {
                quiz = "$number1 - $number2 = "
                txt_misol.text = quiz
                javob = number1 - number2
            }
            2 -> {
                quiz = "$number1 * $number2 = "
                txt_misol.text = quiz
                javob = number1 * number2
            }
            3 -> {
                try {
                    if (number2 < number1) {
                        quiz = "$number1 / $number2 = "
                        txt_misol.text = quiz
                        javob = number1 / number2
                    } else
                        random()
                } catch (e: Exception) {
                    random()
                }
            }
        }
    }
}