package ru.easycode.zerotoheroandroidtdd

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.reflect.KProperty

class SimpleStateViewModel: ViewModel() {

    val state: LiveData<Instance> get() = stateLiveData
    private val stateLiveData = MutableLiveData<Instance>()

    fun initState(instance: Instance) {
        Log.d("SergeyT", state.value.toString())
        stateLiveData.value = instance
    }

    fun changeText() {
        stateLiveData.value = Instance("I am an Android Developer!")
    }
}