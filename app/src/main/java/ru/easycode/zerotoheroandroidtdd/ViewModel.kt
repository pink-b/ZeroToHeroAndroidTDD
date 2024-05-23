package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel: ViewModel() {

    val state : LiveData<Boolean> get() = mutableLiveData
    private val mutableLiveData = MutableLiveData<Boolean>(false)

//    fun initState() {
//        mutableLiveData.value = false
//    }
    fun changeLoadState() {
        val currentState = mutableLiveData.value
        currentState?.let {
            mutableLiveData.postValue(!it)
        }
    }


}