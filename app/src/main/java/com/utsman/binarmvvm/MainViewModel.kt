package com.utsman.binarmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val mainRepository: MainRepository = MainRepositoryImpl()

    val liveCounter: LiveData<Int> = mainRepository.liveCounter

    fun increment() {
        mainRepository.increment()
    }

    fun decrement() {
        mainRepository.decrement()
    }
}