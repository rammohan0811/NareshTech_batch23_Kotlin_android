package com.nareshit.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

fun main(){
    println("Main Program starts: ${Thread.currentThread().name}")
    GlobalScope.launch {
        // This is where you can run a coroutine
        println("coroutine 1 starts: ${Thread.currentThread().name}")
        waitForOneSecond()
        println("coroutine 1 ends: ${Thread.currentThread().name}")
    }

    GlobalScope.launch {
        // This is where you can run a coroutine
        println("coroutine 1 starts: ${Thread.currentThread().name}")
        delay(1000)
        println("coroutine 1 ends: ${Thread.currentThread().name}")
    }

    Thread.sleep(2500)
    println("Main Program Ends: ${Thread.currentThread().name}")
}

suspend fun waitForOneSecond() {
    delay(1000)
}
