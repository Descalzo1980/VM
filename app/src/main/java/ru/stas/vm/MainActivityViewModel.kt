package ru.stas.vm

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {

    var number = 0

    val seconds = MutableLiveData<Int>()
    val finished = MutableLiveData<Boolean>()

    fun addNumber(){
        number++
    }


    fun seconds():LiveData<Int>{
        return seconds
    }

    fun finished(): LiveData<Boolean> {
        return finished
    }

    fun startCounter(){
        object : CountDownTimer(15000, 100) {
            override fun onTick(millisUntilFinished: Long) {
                val time = millisUntilFinished / 1000

                seconds.value = time.toInt()
            }
            override fun onFinish() {
                finished.value = true
            }
        }.start()
    }
}