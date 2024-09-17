package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // intialize component
        val tgl_lahir = findViewById<EditText>(R.id.tgl_lahir)
        val btn_click = findViewById<Button>(R.id.btn_click)
        val tv_result = findViewById<TextView>(R.id.tv_result)

        btn_click.setOnClickListener{
            val input = tgl_lahir.text.toString()
            val result = when(input.toInt()){
                in 1945..1964 -> "You are baby boomer"
                in 1965..1980 -> "You are X"
                in 2000..2016 -> "You are Z"
                else -> "YNTKTS"
            }
            tv_result.text = "$result"
        }
    }
}
