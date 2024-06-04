package com.nareshit.kotlinprograms

import java.util.Scanner



fun main() {
    var s = arrayOf<String>("TDP","BJP","JSP","YSRCP","OTHERS")
    for(i in 0..(s.size-1)){
        if(s[i].equals("BJP")){
            println(i)
        }
    }
}