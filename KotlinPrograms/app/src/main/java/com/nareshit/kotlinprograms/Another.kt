package com.nareshit.kotlinprograms

abstract class RBI{
    /***This function is not open to override - So all the
     * banks that fall under RBI should be implementing the same
     * interest rate
     */
    fun homeLoanInterestRate():Double{
        return 7.65
    }

    abstract fun personalLoan():Double
}

class SBI:RBI(){
    override fun personalLoan(): Double {
        return 6.2
    }
}

class ICICI:RBI(){
    override fun personalLoan(): Double {
        return 7.8
    }
}

fun main(){
    val s:SBI = SBI()
    println(s.homeLoanInterestRate())
    println(s.personalLoan())
}