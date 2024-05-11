package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val count = Count.Base(2)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.incrementButton)
        val text = findViewById<TextView>(R.id.countTextView)


        button.setOnClickListener {
            val newValue = count.increment(text.text.toString())
            text.text = newValue
        }
    }
}