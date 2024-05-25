package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel: ViewModel() {

    val state : LiveData<ChangeState> get() = mutableLiveData
    private val mutableLiveData = MutableLiveData<ChangeState>()

//    fun initState() {
//        mutableLiveData.value = false
//    }
    fun changeLoadState(newData: ChangeState) {
        val currentState = mutableLiveData.value
        currentState?.let {
            mutableLiveData.postValue(it)
        }
    }


}