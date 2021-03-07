package com.example.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var userInputText: EditText? = null
    private var textView: TextView? = null
    private var clickButton: Button? = null
    private var clearButton: Button? = null
    private var resetButton: Button? = null
    private var clicksCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userInputText = findViewById(R.id.editText)
        textView = findViewById(R.id.textView)
        clickButton = findViewById(R.id.clickButton)
        clearButton = findViewById(R.id.clearButton)
        resetButton = findViewById(R.id.resetButton)
        textView?.text = ""
        textView?.movementMethod = ScrollingMovementMethod()
        var inputText = userInputText?.text

        clickButton?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                clicksCount += 1
                textView?.append("$inputText by # of times Button Clicked: $clicksCount")
                if (clicksCount != 1) {
                    textView?.append("s\n")
                } else {
                    textView?.append("\n")
                }
                userInputText?.text?.clear()
            }
        })
        clearTextView()
        resetData()
    }

    fun clearTextView() {
        clearButton?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                textView?.setText("")
            }
        })
    }

    fun resetData() {
        resetButton?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                clicksCount = 0
                textView?.setText("")
                userInputText?.setText("")
            }
        })
    }
}