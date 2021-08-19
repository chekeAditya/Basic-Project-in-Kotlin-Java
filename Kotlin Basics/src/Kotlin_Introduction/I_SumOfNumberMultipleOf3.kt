package Kotlin_Introduction

fun main() {
    val limit = 10
    println("Print number which are multiple of 3 is from 0 to $limit :- ")
    for (i in 0..limit) {
        if (i % 3 == 0) print("$i ")
    }
}