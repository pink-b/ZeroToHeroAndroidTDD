package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    var state: State = State.Initial
    lateinit var linearLayout: LinearLayout
    lateinit var text: TextView
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text = findViewById<TextView>(R.id.titleTextView)
        button = findViewById<Button>(R.id.removeButton)
        linearLayout = findViewById<LinearLayout>(R.id.rootLayout)

        button.setOnClickListener {
            state = State.Remove
            state.apply(linearLayout, text, button)
        }


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable("KEY", state)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        state = savedInstanceState.getSerializable("KEY") as State
        state.apply(linearLayout, text, button)
    }

}

interface State: Serializable {

    fun apply(linearLayout: LinearLayout, textView: TextView, button: Button)

    object Initial: State {
        override fun apply(linearLayout: LinearLayout, textView: TextView, button: Button) {
            TODO("Not yet implemented")
        }

    }

    object Remove: State {
        override fun apply(linearLayout: LinearLayout, textView: TextView, button: Button) {
            linearLayout.removeView(textView)
            button.isEnabled = false

        }

    }

//    object NotEnabled: State {
//        override fun apply(linearLayout: LinearLayout, textView: TextView) {
//            TODO("Not yet implemented")
//        }
//
//    }
}