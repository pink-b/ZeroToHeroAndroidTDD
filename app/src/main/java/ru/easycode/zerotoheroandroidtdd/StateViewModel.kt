package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StateViewModel: ViewModel() {

    val state: LiveData<State> get() = mutableState
    private val mutableState = MutableLiveData<State>()


    fun initState(state: State) {
        mutableState.value = state
    }

    fun removeItem() {
        mutableState.value = state.value?.let { State(!it.textRemoved) }
    }

}