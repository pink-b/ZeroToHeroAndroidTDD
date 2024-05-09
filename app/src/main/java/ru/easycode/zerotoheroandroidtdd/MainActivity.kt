package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var linearLayout: LinearLayout
    lateinit var text: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val button = findViewById<Button>(R.id.removeButton)
        text = findViewById<TextView>(R.id.titleTextView)
        linearLayout = findViewById(R.id.rootLayout)

        if(savedInstanceState == null)
            linearLayout.addView(text)

        button.setOnClickListener {
            linearLayout.removeView(text)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val childCount = linearLayout.childCount == 1
        outState.putBoolean(KEY_ELEMENT, childCount)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val removeTextItem = savedInstanceState.getBoolean(KEY_ELEMENT)
        if(removeTextItem) {
            linearLayout.removeView(text)
        }
    }
    companion object {
        private const val KEY_ELEMENT = "KEY_ELEMENT"
    }
}
