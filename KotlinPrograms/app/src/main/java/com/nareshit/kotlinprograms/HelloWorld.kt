package com.nareshit.kotlinprograms

import java.util.Scanner

fun main(){
    println("Choose your option:\n1.Square\n2.Twice\n3.Half")
    val s:Scanner = Scanner(System.`in`)
    val input = s.nextInt()

    println("Enter a number")
    val number = s.nextInt()

    val result = when(input){
        1 -> number*number
        2 -> 2*number
        3 -> number/2
        else -> 0
    }

    println(result)
}