package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class MainViewModel(private val liveDataWrapper: LiveDataWrapper, private val repository: Repository) {

    private val viewModelScope = CoroutineScope(SupervisorJob())
    fun update(uiState: UiState) {
        liveDataWrapper.update(uiState)
    }

    fun getLiveData(): LiveData<UiState> {
        return liveDataWrapper.liveData()
    }
    fun load(){
        liveDataWrapper.update(UiState.ShowProgress)
        viewModelScope.launch {
            repository.load()
            liveDataWrapper.update(UiState.ShowData)
        }
    }

}