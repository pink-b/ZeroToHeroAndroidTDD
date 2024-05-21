package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel: ViewModel() {

    val state: LiveData<UiState> get() = mutableLiveData
    var mutableLiveData = MutableLiveData<UiState>()

    fun initState(value: UiState) {
        mutableLiveData.value = value
    }

    fun editValue(value: UiState) {
        mutableLiveData.value = value
    }
}