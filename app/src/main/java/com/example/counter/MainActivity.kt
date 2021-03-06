package com.example.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    private var userInputText: EditText? = null
    private var textView: TextView? = null
    private var clickButton: Button? = null
    private var clicksCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userInputText = findViewById(R.id.editText)
        textView = findViewById(R.id.textView)
        clickButton = findViewById(R.id.clickButton)

        clickButton?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                clicksCount += 1
                textView?.append("\n # of times Button Clicked: $clicksCount")
            }
        })
    }
}