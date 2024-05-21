package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {
    val count = Count.Base(2, 4)

    val viewModel by viewModels<ViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.incrementButton)
        val text = findViewById<TextView>(R.id.countTextView)

        if(viewModel.state == null) {
            viewModel.initState(UiState.Base("0"))
        }

        viewModel.state.observe(this, Observer {
            text.text = it.text
            if(it is UiState.Max) {
                button.isEnabled = false
            }
        })

        button.setOnClickListener {
            val newCount = count.increment(text.text.toString())
            viewModel.editValue(newCount)
            text.text = viewModel.state.value!!.text
        }


    }
}