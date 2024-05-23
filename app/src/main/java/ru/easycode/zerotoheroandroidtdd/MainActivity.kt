package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer


class MainActivity : AppCompatActivity() {

    val viewModel by viewModels<ViewModel>()

    val stateChanger = ChangeState()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loadButton = findViewById<Button>(R.id.actionButton)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val text = findViewById<TextView>(R.id.titleTextView)

//        stateChanger.initState(loadButton, text, progressBar)

        loadButton.setOnClickListener {
            viewModel.changeLoadState()
            loadButton.postDelayed({
                viewModel.changeLoadState()
            }, 3500)

        }

        viewModel.state.observe(this, Observer {
            stateChanger.apply(loadButton, text, progressBar, viewModel.state.value)
        })
    }



}