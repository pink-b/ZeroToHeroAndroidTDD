package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible

interface ChangeState {

    fun apply(button: Button, textView: TextView, progressBar: ProgressBar)

    class InitState(): ChangeState {
        override fun apply(
            button: Button,
            textView: TextView,
            progressBar: ProgressBar,
        ) {
            progressBar.isVisible = false
            textView.isVisible = false
            button.isEnabled = true
        }

    }

    class LoadState(): ChangeState {
        override fun apply(
            button: Button,
            textView: TextView,
            progressBar: ProgressBar,
        ) {
            progressBar.isVisible = true
            textView.isVisible = false
            button.isEnabled = false
        }

    }

    class LoadedState(): ChangeState {
        override fun apply(
            button: Button,
            textView: TextView,
            progressBar: ProgressBar,
        ) {
            progressBar.isVisible = false
            textView.isVisible = true
            button.isEnabled = true
        }

    }

//    fun initState(button: Button, textView: TextView, progressBar: ProgressBar) {
//        progressBar.isVisible = false
//        textView.isVisible = false
//        button.isEnabled = true
//    }
//    fun apply(button: Button, textView: TextView, progressBar: ProgressBar, isLoad: Boolean?) {
//        if(isLoad!!) {
//            progressBar.isVisible = true
//            textView.isVisible = false
//            button.isEnabled = false
//        } else {
//            progressBar.isVisible = false
//            textView.isVisible = true
//            button.isEnabled = true
//
//        }
//    }
}