package com.example.calc_on_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_null.setOnClickListener { setTextFields("0") }
        btn_one.setOnClickListener { setTextFields("1") }
        btn_two.setOnClickListener { setTextFields("2") }
        btn_three.setOnClickListener { setTextFields("3") }
        btn_for.setOnClickListener { setTextFields("4") }
        btn_five.setOnClickListener { setTextFields("5") }
        btn_six.setOnClickListener { setTextFields("6") }
        btn_seven.setOnClickListener { setTextFields("7") }
        btn_eight.setOnClickListener { setTextFields("8") }
        btn_nine.setOnClickListener { setTextFields("9") }
        btn_dot.setOnClickListener { setTextFields(".") }
        btn_minus.setOnClickListener { setTextFields("-") }
        btn_plus.setOnClickListener { setTextFields("+") }
        btn_multiply.setOnClickListener { setTextFields("*") }
        btn_devision.setOnClickListener { setTextFields("/") }
        btn_bracket_left.setOnClickListener { setTextFields("(") }
        btn_bracket_right.setOnClickListener { setTextFields(")") }
        btn_all_clear.setOnClickListener {
            math_operation.text = ""
            result_text.text = ""
        }
        btn_delete.setOnClickListener {
            val str = math_operation.text.toString()
            if (str.isEmpty())
                math_operation.text = str.substring(0, str.length -1)
            result_text.text = ""
        }
        btn_result.setOnClickListener {
            try {
                val ex = ExpressionBuilder(math_operation.text.toString()).build()
                val result = ex.evaluate()
                val longRes = result.toLong()
                if (result == longRes.toDouble())
                    result_text.text = longRes.toString()
                else
                    result_text.text = result.toString()
            }catch (e:Exception) {
                Log.d("Ошибка" ,"сообщение: ${e.message}")
            }
        }

    }
    fun setTextFields(str: String){
        if (result_text.text != ""){
            math_operation.text = result_text.text
        }
        math_operation.append(str)
    }
}