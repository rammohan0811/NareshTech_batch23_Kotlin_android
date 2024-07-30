package com.nareshit.scoretrackermvvm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel {

    var count:MutableLiveData<Int>
    constructor(){
        // This constructor is initalized when the object for MainViewModel is created
        Log.v("Main","ViewModel is created")
        count = MutableLiveData()
        count.value = 0
    }

    fun increment(){
        count.value = count.value?.plus(1)
    }

    fun decrement(){
        count.value = count.value?.minus(1)
    }


    override fun onCleared() {
        super.onCleared()
        // This method is encountered when the viewmodel is destroyed.
        Log.v("Main","ViewModel is destroyed")
    }
}