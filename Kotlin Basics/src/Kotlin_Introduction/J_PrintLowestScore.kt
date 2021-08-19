package Kotlin_Introduction

fun main() {
    val arr = arrayListOf<Int>(16, 1, 2, 3, 4, 5, 12)
    var lowest = arr[0]
    for (i in 0 until arr.size) {
        if (arr[i] < lowest)
            lowest = arr[i]
    }
    println("Lowest Score is $lowest")
}