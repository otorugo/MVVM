package com.example.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private var _counter = MutableLiveData(100)
    val counter get() = _counter


    fun increaseCounter() {
        _counter.value = _counter.value!! + 1
    }

    fun decreaseCounter() {
        _counter.value = _counter.value!! - 1
    }


}