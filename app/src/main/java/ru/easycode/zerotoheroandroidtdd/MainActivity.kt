package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.easycode.zerotoheroandroidtdd.State

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<SimpleStateViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text = findViewById<TextView>(R.id.titleTextView)
        val button = findViewById<Button>(R.id.hideButton)

        button.setOnClickListener {
            viewModel.hideText()
        }

        if(viewModel.state.value == null) {
            Log.d("SergeyT", "sucsess")
            viewModel.initState(State(
                KEY_STATE_HIDE
            ))
        }

        viewModel.state.observe(this, Observer {
            Log.d("SergeyT", it.toString())
            text.isVisible = it.textHide
        })
    }


    companion object {
        private val KEY_STATE_HIDE = true
    }

}

