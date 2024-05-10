package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    private var state: StatePattern = StatePattern.Initial
    lateinit var linearLayout: LinearLayout
    lateinit var text: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.removeButton)
        text = findViewById<TextView>(R.id.titleTextView)
        linearLayout = findViewById(R.id.rootLayout)



        button.setOnClickListener {
            state = StatePattern.Removed
            state.apply(linearLayout, text)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable("KEY", state)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        state = savedInstanceState.getSerializable("KEY") as StatePattern
        state.apply(linearLayout, text)
    }


}

interface StatePattern: Serializable {

    fun apply(linearLayout: LinearLayout, text: TextView)
    object Initial: StatePattern {
        override fun apply(linearLayout: LinearLayout, text: TextView) {
            Unit
        }

    }

    object Removed: StatePattern {
        override fun apply(linearLayout: LinearLayout, text: TextView) {
            linearLayout.removeView(text)
        }

    }
}
