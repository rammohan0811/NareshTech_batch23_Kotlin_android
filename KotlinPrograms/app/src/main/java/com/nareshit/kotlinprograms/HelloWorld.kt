package com.nareshit.kotlinprograms

/*
* Dog -> real world Entity
* 3 attributes
*   - name
*   - age
*   - weight
* 2 behaviors
*   - display()
*   - bark()
* */

class Dog(var name:String?, var age:Int?, var weight:Double?){

    constructor(name:String?):this(name,10,12.34)
    constructor(name:String?, weight: Double?):this(name, 14, weight)
    fun display(){
        println("$name of age $age is of weight $weight")
    }
    fun bark(){
        println("Bow! Bow!")
    }
}
fun main(){
    // Create a copy of the class (Object or Instance)
    val tommy = Dog("Tim Tommy", 10,12.5)
    tommy.bark()
    tommy.display()

    val jimmy = Dog("Sandra")
    jimmy.display()
}