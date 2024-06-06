package com.nareshit.kotlinprograms
class Internals{
    internal var a = 10
}
fun main(){
    var i = Internals()
    println("${i.a}")
}