package com.example.alertdialog

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View.inflate
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.view.setPadding

class MainActivity : AppCompatActivity() {

    lateinit var btShow : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btShow = findViewById(R.id.btShow)


        btShow.setOnClickListener {
            customAlert()
        }
    }

    private fun customAlert() {
        val dialogBuilder = AlertDialog.Builder(this)
        val mLayout = LinearLayout(this)
        val tvAlert = TextView(this)
        val etAlert = EditText(this)

        tvAlert.text = "Show"
        tvAlert.setTextSize(TypedValue.COMPLEX_UNIT_SP,16f)
        etAlert.setSingleLine()
        etAlert.hint = "enter your name"
        mLayout.orientation = LinearLayout.VERTICAL
        mLayout.addView(tvAlert)
        mLayout.addView(etAlert)

        mLayout.setPadding(50,40,50,10)


        dialogBuilder.setMessage("Enter your message: ")
            .setNegativeButton("tv" , DialogInterface.OnClickListener {

                    _, _ ->
                val name = etAlert.text.toString()
                tvAlert.text = "Name is: " + name

            })
            .setPositiveButton("Go",DialogInterface.OnClickListener {
                    _, _ ->
                        val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("info" , etAlert.text.toString())
                         startActivity(intent)


            })
        val alert = dialogBuilder.create()
        alert.setTitle("new Message")
        alert.setView(mLayout)
        alert.show()
    }
}