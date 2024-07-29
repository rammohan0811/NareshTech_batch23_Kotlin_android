package com.nareshit.scoretrackermvvm

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel {

    var count = 0;
    constructor(){
        // This constructor is initalized when the object for MainViewModel is created
        Log.v("Main","ViewModel is created")
    }

    fun increment(){
        count++
    }

    fun decrement(){
        count--
    }


    override fun onCleared() {
        super.onCleared()
        // This method is encountered when the viewmodel is destroyed.
        Log.v("Main","ViewModel is destroyed")
    }
}