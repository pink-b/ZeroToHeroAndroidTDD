package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import ru.easycode.zerotoheroandroidtdd.Instance

class MainActivity : AppCompatActivity() {

    lateinit var state: Instance
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text = findViewById<TextView>(R.id.titleTextView)
        val button = findViewById<Button>(R.id.changeButton)



        state = savedInstanceState?.getParcelable(KEY_STATE) ?: Instance(
            "Hello World!"
        )
        text.text = state.text

        button.setOnClickListener {
            text.text = "I am an Android Developer!"
            state.text = "I am an Android Developer!"
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(KEY_STATE, state)
    }


companion object {
    private val KEY_STATE = "KEY_STATE"
}

}

