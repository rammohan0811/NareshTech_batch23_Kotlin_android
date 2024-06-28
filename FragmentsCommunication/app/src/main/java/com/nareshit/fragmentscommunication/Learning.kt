package com.nareshit.fragmentscommunication

class Example(val name:String, val age:Int){
    companion object{
        fun initialize():Example{
            return Example("Pavan", 12)
        }
    }
}

class MyClass{

    fun hello(){
        // non static - belongs to object
        println(MyClass.returnValue())
    }
    companion object{
        var i = 0
        fun initialize():MyClass{
            i++
            return MyClass()
        }
        fun returnValue():Int{
            return i
        }

    }
}
fun main(){
    /*val e = Example.initialize()
    println(e.name)*/
    val obj1 = MyClass.initialize()
    val obj2 = MyClass.initialize()
    val obj3 = MyClass.initialize()
    val obj4 = MyClass.initialize()
    val obj5 = MyClass.initialize()
    val obj6 = MyClass.initialize()
    val obj7 = MyClass.initialize()
    val obj8 = MyClass.initialize()
    val obj9 = MyClass.initialize()
    val obj10 = MyClass.initialize()
    obj10.hello()
    println(MyClass.i)
}