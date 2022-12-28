package ru.stas.vm

import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {

    var number = 0

    fun addNumber(){
        number++
    }
}