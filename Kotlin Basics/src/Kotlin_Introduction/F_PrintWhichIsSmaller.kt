package Kotlin_Introduction

fun main(){
    val num1 = 10
    val num2 = 12
    val num = if (num1 < num2) num1 else num2
    println("Smaller number is $num")
}