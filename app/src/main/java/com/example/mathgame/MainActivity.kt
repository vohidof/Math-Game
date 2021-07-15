package com.example.mathgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_keyingi.setOnClickListener{
            val name = edt_name.text.toString().trim()
            val misolNumber = edt_misol_number.text.toString()

            if(name.isNotEmpty() && misolNumber.isNotEmpty()){
                val intent = Intent(this, Savol::class.java)
                intent.putExtra("misolSoni", misolNumber)
                intent.putExtra("name", name)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Input the data", Toast.LENGTH_SHORT).show()
            }
        }
    }
}