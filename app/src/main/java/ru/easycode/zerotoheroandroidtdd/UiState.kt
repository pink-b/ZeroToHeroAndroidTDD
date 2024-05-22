package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView

interface UiState {

    var text: String

    fun apply(incrementButton: Button, decrementButton: Button, textView: TextView)
    data class Min(override var text: String): UiState {
        override fun apply(incrementButton: Button, decrementButton: Button, textView: TextView) {
            decrementButton.isEnabled = false
            textView.text = text
        }
    }

    data class Base(override var text: String): UiState {
        override fun apply(incrementButton: Button, decrementButton: Button, textView: TextView) {
            incrementButton.isEnabled = true
            decrementButton.isEnabled = true
            textView.text = text
        }
    }

    data class Max(override var text: String): UiState {
        override fun apply(incrementButton: Button, decrementButton: Button, textView: TextView) {
            incrementButton.isEnabled = false
            textView.text = text
        }
    }

}