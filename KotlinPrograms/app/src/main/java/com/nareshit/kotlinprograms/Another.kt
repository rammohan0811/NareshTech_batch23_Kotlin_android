package com.nareshit.kotlinprograms

fun main(){
    val s = Second()
    println(s.sum(10,20))
    println(s.sum(10,20,30))
}
open class First{
    open fun sum(a:Int, b:Int) = a+b
}

class Second:First(){
    override fun sum(a:Int, b:Int) = a*b
    fun sum(a:Int, b:Int, c:Int) = super.sum(10,20)+c
}