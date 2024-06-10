package com.nareshit.kotlinprograms

interface Animal{
    val name:String
    fun sound():String

    // Default implementation of Method
    fun printDetails(){
        println("Animal:$name , Sound: ${sound()}")
    }
}

class Dog(override val name:String):Animal{
    override fun sound(): String = "Bark"
}

class Cat(override val name:String):Animal{
    override fun sound(): String = "Meow"
}

fun main(){
    val dog = Dog("Buddy")
    val cat = Cat("Whiskers")

    dog.printDetails()
    cat.printDetails()
}