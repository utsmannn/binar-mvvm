package com.utsman.binarmvvm

import androidx.lifecycle.LiveData

interface MainRepository {
    // tidak dizinkan berubah seperti
    // mainRepository.liveCounter.postValue(1)
    val liveCounter: LiveData<Int>

    // di izinkan berubah menggunakan trigger function
    // di bawah
    fun increment()
    fun decrement()
}