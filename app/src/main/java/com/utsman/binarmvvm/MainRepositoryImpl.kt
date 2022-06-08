package com.utsman.binarmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

// livedata adalah salah satu approach untuk melakukan
// pendekatan asynchronous programming
// maka dia mengadopsi konsep "mewaktu"
class MainRepositoryImpl : MainRepository {

    private val _liveCounter: MutableLiveData<Int> = MutableLiveData(0)
    override val liveCounter: LiveData<Int> get() = _liveCounter

    override fun increment() {
        val updatedValue = getValueCounterCurrent() + 1
        _liveCounter.postValue(updatedValue)
    }

    override fun decrement() {
        val updatedValue = getValueCounterCurrent() - 1
        _liveCounter.postValue(updatedValue)
    }

    private fun getValueCounterCurrent(): Int {
        return liveCounter.value ?: 0
    }
}