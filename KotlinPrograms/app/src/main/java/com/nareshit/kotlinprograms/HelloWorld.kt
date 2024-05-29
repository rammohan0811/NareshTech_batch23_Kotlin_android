package com.nareshit.kotlinprograms

// Import java's Scanner Class
import java.util.Scanner

fun main(){
    println("Enter your first value:")
    val s:Scanner = Scanner(System.`in`)
    val a = s.nextInt()
    println("Enter your second value:")
    val b = s.nextInt()
    println("$a + $b = ${a+b}")
}