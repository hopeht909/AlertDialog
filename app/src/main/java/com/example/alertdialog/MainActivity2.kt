package com.example.alertdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {

    lateinit var tvShow : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        tvShow = findViewById(R.id.tv)

       val str1 =  intent.getStringExtra("info")
        tvShow.text = "$str1"
    }
}