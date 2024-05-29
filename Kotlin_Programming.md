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