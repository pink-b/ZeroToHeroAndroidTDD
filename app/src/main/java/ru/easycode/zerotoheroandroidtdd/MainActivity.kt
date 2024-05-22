package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

    val count = Count.Base(2, 4, 0)

    val viewModel by viewModels<ViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text = findViewById<TextView>(R.id.countTextView)
        val buttonIncrement = findViewById<Button>(R.id.incrementButton)
        val buttonDecrement = findViewById<Button>(R.id.decrementButton)
        Log.d("Sergey", viewModel.state.toString())
        if(viewModel.state.value == null) {
            Log.d("Sergey", viewModel.state.toString())
            viewModel.newState(count.initial(text.text.toString()))
        }


        buttonDecrement.setOnClickListener {
            val newValue = count.decrement(text.text.toString())
            viewModel.newState(newValue)
        }



        buttonIncrement.setOnClickListener {
            val newValue = count.increment(text.text.toString())
            viewModel.newState(newValue)
        }

        viewModel.state.observe(this, Observer {
            it.apply(buttonIncrement, buttonDecrement, text)
        })
    }
}