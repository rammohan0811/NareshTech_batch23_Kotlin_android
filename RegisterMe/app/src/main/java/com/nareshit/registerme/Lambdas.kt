package com.nareshit.registerme

fun main(){
    // sum of Two numbers
    println({a:Int, b:Int -> a+b}(10,20))
    val numbers = listOf(1,2,3,4,5,6)
    println(numbers)
    numbers.forEach { print("$it ") }
    val evenNumbers = numbers.filter { it%2 == 0 }
    println()
    println(evenNumbers)
    val squares = numbers.map { it*it }
    println(squares)
}

fun sum(a:Int, b:Int):Int{
    return a+b
}