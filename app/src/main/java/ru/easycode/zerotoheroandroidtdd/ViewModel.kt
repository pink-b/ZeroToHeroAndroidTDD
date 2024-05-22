package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
class ViewModel: ViewModel() {

    val state: LiveData<UiState> get() = mutableState
    private val mutableState = MutableLiveData<UiState>()

    fun newState(value: UiState) {
        mutableState.value = value
    }

}