package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SimpleStateViewModel: ViewModel() {

    private val stateLifeData = MutableLiveData<State>()
    val state: LiveData<State> = stateLifeData

    fun initState(state: State) {
        stateLifeData.value = state
    }

    fun hideText() {
        stateLifeData.value = stateLifeData.value?.let { State(!it.textHide) }
    }

}