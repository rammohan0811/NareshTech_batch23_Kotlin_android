# Kotlin Essentials for Android App Development

Refer to the [official documentation](https://kotlinlang.org/docs/home.html)

### Why learn Kotlin Programming language for Android ?
1. Google Announced kotlin as the official programming language for android. 
2. Over 50% of Professional android developers use kotlin as their primary programming language. Only 30% of the developers use Java still. All the kotlin users (developers) said that kotlin makes them more productive. 
3. Benefits
   1. Less code combined with greater readability
   2. Fewer common errors
   3. Kotlin offers a great set of jetpack libraries - extensive support is also there.
   4. Mature language and the environment is also equally matured. 
   5. Interoperability with the Java
   6. Easy Learning
   7. Big Community

### How to run Kotlin Programs ?
- You can run kotlin programs in Android studio
- You can also use Intellij IDEA
- You can also integrate Kotlin into Visual studio code.
- You can also kotlin programs [online](https://play.kotlinlang.org/)

### Introduction to Kotlin Programming Language
Kotlin is a statically typed, modern programming langauge that targets the Java Virtual Machine, Android, Java Script and native platforms. 
- Kotlin is developed by JetBrains and officially released in 2011. 
#### Features of Kotlin
- Conciseness
- Interoperability
- Null Safe
- Functional Programming features
- Coroutines

### First Kotlin Program

```kotlin
fun main(){
    println("Hello World!")
}
```
***Output***
```
Hello World!
```

***All your kotlin files will have `.kt` extension***

***Your kotlin programs execution always begins from `main()` function***

### Working with variables in Kotlin
- There are two types of variables in kotlin
  - Immutable variables (Cannot be changed)
  - Mutable Variables (can change)
- Immutable variables
  ```kotlin
  package com.nareshit.kotlinprograms
    fun main() {
        // Declaring and initializing the immutable variable
        // Kotlin programming language has Type Inference
        // Type Inference allows us to assign a value to a variable and the type of the variable
        // will be defined by kotlin compiler.
        val x = 10
        // val y:Int = 2
        // x = 12 - Error: val cannot be re-assinged
        println(x)
    }
  ```

  ***Output***
  ```
  10
  ```

  - Mutable Variable

    ```kotlin
    package com.nareshit.kotlinprograms

    fun main() {
        // Declaring and initializing the mutable variable
        // Kotlin programming language has Type Inference
        // Type Inference allows us to assign a value to a variable and the type of the variable
        // will be defined by kotlin compiler.
        var x = 10
        x = 13
        println(x)
    }
    ```

***Output***
```
13
```

#### Check the data type of variables - to understand `TypeInference` concept

```kotlin
package com.nareshit.kotlinprograms

fun main() {
    val x = 10
    val y = 13.45
    val z = false
    println(x::class.java.simpleName)
    println(y::class.java.simpleName)
    println(z::class.java.simpleName)
}
```

***Output***
```
int
double
boolean
```

### Data Types in Kotlin

Kotlin supports a set of built in types that represent numbers.
For``` Integer numbers``` there are four types with different sizes and hence the value ranges
- Byte
- Short
- Int
- Long

When you initialize a variable with no explicit type specification, the compiler automaticalle infers the type with the smallest range enough to represent the value starting from Int. 

If the value is not exceeding the range of Int, the type is Int. If it exceeds the range of Int, the type will be Long. 

To specify a Long value, we need to append the suffix L to the value. 

```kotlin
package com.nareshit.kotlinprograms

fun main() {
    val x = 10
    println(x::class.java.simpleName)

    val y = 10000000000
    println(y::class.java.simpleName)
}
```

***Output***
```
int
long
```

***In Kotlin, unlike java, all data types are Non Primitive.***

Every data type will have the first letter captialized. 

#### Floating-Point DataTypes
- Float (single Precision)
- Double (Double Precision)
To represnt a float value, add `F` or `f` as suffix to the actual value. 

```kotlin
fun main() {
    val x = 10.90212231
    println(x::class.java.simpleName)

    val y:Float = 10.234f
    println(y::class.java.simpleName)
}
```

***Output***
```
double
float
```

#### Explicit Type Conversion
- toByte()
- toShort()
- toInt()
- toLong()
- toFloat()
- toDouble()

```kotlin 
package com.nareshit.kotlinprograms

import android.os.Build
import androidx.annotation.RequiresApi


fun main() {
    // Upconversion -> Changing a value of a lower size to a higher size.
    val a:Byte = 1
    val b = a.toInt()
    println(b::class.java.simpleName)

    // Downconversion -> Changing a value of a higher size to a lower size.
    val a1 = 1234 // this is an integer
    val b1 = a1.toByte()
    println(b1)
}
```

***Output***
```
int
-46
```

***We can even declare the variables in global section so that the variables can be accessed by other functions in the program.***

```kotlin
package com.nareshit.kotlinprograms

var a = 0
fun main() {
    println(a)
    increment()
    println(a)
}

fun increment(){
    a++
}
```

***Output***
```
0
1
```

### Functions in Kotlin

- All functions in kotlin must be defined with a keyword called `fun`.
- The return type of a function should be mentioned after the function declaration

```Kotlin
package com.nareshit.kotlinprograms

/*The following function, takes two integers, adds them up and returns the result*/
fun sum1(a:Int, b:Int):Int{
    return a+b
}

/*
* The following function takes three integers, adds them up and prints the result*/
fun sum2(a:Int, b:Int, c:Int):Unit{
    println(a+b+c)
}

fun main() {
    println(sum(10,20))
    sum2(10,20,30)

    println(sum(12,13))
    println(sum3(12,13,25))
}

/**
 * In KOtlin, functions can go in one single line*/
fun sum(a:Int, b:Int) = a+b
fun sum3(a:Int, b:Int, c:Int):Int = a+b+c
```

***output***
```
30
60
25
50
```

**Problem Statement**: I want to get an output like the following

`the sum of 10 and 20 is 30`

```kotlin
fun main(){
    val a = 10
    val b = 20
    println("the sum of $a and $b is ${a+b}")
}
```

***Output***
```
the sum of 10 and 20 is 30
```

### Using Existing Java Libraries in Kotlin (Interoperability with Java)

```kotlin
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
```
***Output***
```
Enter your first value:
10
Enter your second value:
20
10 + 20 = 30
```
### Conditional Expressions in Kotlin

```Kotlin
package com.nareshit.kotlinprograms

/**
 * Program to identify if any given Integer number is even or not*/

import java.util.*

fun main(){
    val s:Scanner = Scanner(System.`in`)
    println("Enter a number")
    val number = s.nextInt()
    if(number%2 == 0){
        println("Even")
    }else{
        println("Not Even")
    }
}
```
***Output***

```
Enter a number
6
Even
```

***Using functions with Conditional Expressions***
```kotlin
package com.nareshit.kotlinprograms

/**
 * Program to identify if any given Integer number is even or not*/

import java.util.*

fun main(){
    val s:Scanner = Scanner(System.`in`)
    println("Enter a number")
    val n = s.nextInt()
    isEven(n)
}

fun isEven(number:Int){
    if(number%2 == 0){
        println("Even")
    }else{
        println("Not Even")
    }
}
```

***Output will be the same as above***

***Kotlin Conciseness example***
```kotlin
package com.nareshit.kotlinprograms

/**
 * Program to identify if any given Integer number is even or not*/

import java.util.*

fun main(){
    val s:Scanner = Scanner(System.`in`)
    println("Enter a number")
    val n = s.nextInt()
    if(n%2==0) println("Even") else println("Not Even")
}
```
***Output will be the same as above***

```Kotlin
package com.nareshit.kotlinprograms

/**
 * Program to identify if any given Integer number is even or not*/

import java.util.*

fun main(){
    val s:Scanner = Scanner(System.`in`)
    println("Enter a number")
    val n = s.nextInt()
    if(isEven(n)) println("Even") else println("Not Even")
}

fun isEven(number:Int) = if(number%2==0) true else false
```

***Output will be the same as above***

```kotlin
package com.nareshit.kotlinprograms

/**
 * Program to identify if any given Integer number is even or not*/

import java.util.*

fun main(){
    val s:Scanner = Scanner(System.`in`)
    println("Enter a number")
    val n = s.nextInt()
    val status = if(n%2==0) true else false
    if(status) println("Even") else println("Not Even")
}
```

***Output will be the same as above***

```kotlin
package com.nareshit.kotlinprograms

/**
 * Program to identify if any given Integer number is even or not*/

import java.util.*

fun main(){
    val s:Scanner = Scanner(System.`in`)
    println("Enter a number")
    val n = s.nextInt()
    if(if(n%2==0) true else false) println("Even") else println("Not Even")
}
```

***Output will be the same as above***

**Logical Operators in Kotlin**

- && -> And
- || -> Or
- ! -> Logical Not

#### Assignment

***A certain grade of steel has to be graded when Hardness, tensile strength and carbon content are given. these values must meet the following criteria***
- condition 1: Hardness must be greater than or equal to 50
- condition 2: Tensile Strength must be Less than or equal to 5600
- condition 3: carbon content must be less than 0.7

***The grades must be printed as follows***
- if all three conditions are met, the grade is 10
- if only 1 & 2 are met, the grade is 9
- if only 2 & 3 are met, the grade is 8
- If only 1 & 3 are met, the grade is 7
- If only one of the three conditions is true and the others are false, the grade is 6.
- If no codition is met, the grade is 5

```kotlin
package com.nareshit.kotlinprograms

/**
 * Program to identify if any given Integer number is even or not*/

import java.util.*

fun gradeSteel(hardness: Int, tensileStrength: Int, carbonContent: Double): Int {
    val condition1 = hardness >= 50
    val condition2 = tensileStrength <= 5600
    val condition3 = carbonContent < 0.7

    return when {
        condition1 && condition2 && condition3 -> 10
        condition1 && condition2 -> 9
        condition2 && condition3 -> 8
        condition1 && condition3 -> 7
        condition1 || condition2 || condition3 -> 6
        else -> 5
    }
}

fun main() {
    val hardness = 49
    val tensileStrength = 5600
    val carbonContent = 0.7

    val grade = gradeSteel(hardness, tensileStrength, carbonContent)
    println("The grade of the steel is: $grade")
}
```

### When Expression
`when` in kotlin is like `switch` in java & C Programming language. `when` is used when you have multiple branches and when the code looks complex with these multiple branches if used with an if condition. 

```kotlin
package com.nareshit.kotlinprograms

import java.util.Scanner

fun main(){
    println("Choose your option:\n1.print Hello world\n2.calculate area of rect")
    val s:Scanner = Scanner(System.`in`)
    val input = s.nextInt()
    when(input){
        1 -> println("Hello World")
        2 ->{
            println("Enter length:")
            val l = s.nextInt()
            println("Enter breadth:")
            val b = s.nextInt()
            println(l*b)
        }

        else -> println("Irrelevant Option chosen")
    }
}
```

***Output***
```
Choose your option:
1.print Hello world
2.calculate area of rect
3
Irrelevant Option chosen

Process finished with exit code 0
```

```kotlin
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
```

```
Choose your option:
1.Square
2.Twice
3.Half
1
Enter a number
5
25

Process finished with exit code 0

```

### Loops in Kotlin
When you want to repeat a set of statements for some number of times or till the condition fails, we can employ loops. 

`in` -> is a keyword in kotlin that works with range of values or a collection. 

The `for` loop in Kotlin

`..` -> this defines the range 1..10 -> it means 1 to 10.

```kotlin

fun main(){
    for(i in 1..10){
        println("$i")
    }
}
```

```kotlin
fun main(){
    for(i in 23..45){
        println("$i")
    }
}
```

##### Assignment:
Print all the even numbers between any given range of numbers. Read the range from the user. Also include both the Lower bound and upper bound

```kotlin
package com.nareshit.kotlinprograms

import java.util.Scanner

fun main() {
    val s = Scanner(System.`in`)
    println("Enter the lower bound")
    val lowerBound = s.nextInt()
    println("Enter the lower bound")
    val upperBound = s.nextInt()
    if(lowerBound%2 == 0){
        for(i in lowerBound .. upperBound step 2) {
            println(i)
        }
    }else{
        for(i in lowerBound+1 .. upperBound step 2) {
            println(i)
        }
    }

}
```

`step` is a keyword in kotlin that helps you increase the increment or decrement value of the loop counter (ie., i in this case)

```kotlin
fun main() {
 for(i in 20 downTo 1){
     print("$i ")
 }
}
```

`downTo` is a keyword in kotlin that helps us come from an upperbound to a lowerbound. By default, the loop counter decremtns to the next value.

##### Assignment: Print all the odd numbers from 234 down to 189

```KOTLIN
fun main() {
 for(i in 233 downTo 189 step 2){
     print("$i ")
 }
}
```

`while` & `do-while` works the same way as the ones we have in `c`, `c++`, `java` & `python`

```kotlin
package com.nareshit.kotlinprograms

import java.util.Scanner

fun main(){
    var i = 10
    while(i>=1){
        print("$i ")
        i--
    }

    println()

    do{
        print("$i ")
        i++
    }while(i<=10)
}
```

`Repeat`

```kotlin
fun main(){
    repeat(10){
        print("Pavan ")
    }
}
```

### Assignments:

1. Write a program to print if a given number is prime or not
2. Print all the prime numbers between any given range of numbers
3. print all the prime numbers that are palindromic in nature between 1 and 10,000.
4. Write a program to find if a number is present in the fibnocci series 
5. Write a program to find the factorial of any given number. 

[Test Link here](https://forms.gle/aQnoJ3dAMRLMv9WT9)

### Arrays in Kotlin
Array is one of the most fundamental Data structure in practically all programming languages. The idea behind an array is to store multiple items of the same data type, such as integers or strings under a single variable name. 

Arrays are used to organize data in programming so that a related set of values can easily be stored or searched for.

**Important points to make a note of**
1. They are stored in contigeous memory locations.
2. They can be accessed programmatically through their indices.
3. They are mutable.
4. Their size is fixed. 
5. The index of an array starts at 0 and ends at 1 less than the actual size. 

***Create an array with the help of `arrayOf()` & `arrayOf<DATATYPE>()` functions. 

```kotlin
package com.nareshit.kotlinprograms

import java.util.Scanner

fun main(){
    val a = arrayOf(1,2,3,4,5) // even declaring an array as val the values can still change
    a[1] = 10
    // How do we know the size of an array
    println("The size of the array is ${a.size}")
    // Loop through the array
    for(i in a){
        print("$i ")
    }

    println()

    for(i in 0..a.size-1){
        print("${a[i]} ")
    }

    println()
    println(a.get(3))
    a.set(2,12)
    println(a.get(2))
}
```

```kotlin
package com.nareshit.kotlinprograms

import java.util.Scanner

fun main() {
    var s = arrayOf<String>("TDP","BJP","JSP","YSRCP","OTHERS")
    for(i in s){
        print("$i ")
    }
}
```

**Using Array() constructor**
```kotlin
package com.nareshit.kotlinprograms

import java.util.Scanner

fun main() {
    println("Enter the size of the array")
    val s = Scanner(System.`in`)
    val l = s.nextInt()
    val a = Array<Int>(l,{i->i*1})
    var i = 0
    while(i<a.size){
        println("Enter the array value")
        val n = s.nextInt()
        a[i] = n // a.set(i,n)
        i++
    }

    for(j in a){
        print("$j ")
    }
}
```

### OOPs in Kotlin
