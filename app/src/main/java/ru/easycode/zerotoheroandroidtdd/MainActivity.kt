package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<StateViewModel>()

    lateinit var linearLayout: LinearLayout
    lateinit var text: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.removeButton)
        text = findViewById<TextView>(R.id.titleTextView)
        linearLayout = findViewById(R.id.rootLayout)

        if (viewModel.state.value == null) {
            viewModel.initState(State(linearLayout.childCount == 1))
        }

        viewModel.state.observe(this, Observer {
            if (it.textRemoved) {
                linearLayout.removeView(text)
            }
        })



        button.setOnClickListener {
            linearLayout.removeView(text)
            viewModel.removeItem()
        }
    }


}
