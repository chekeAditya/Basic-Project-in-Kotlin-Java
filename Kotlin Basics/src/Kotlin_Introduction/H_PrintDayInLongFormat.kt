package Kotlin_Introduction

fun main() {
    val day = "Saturday"
    when(day){
        "Monday" -> println("Mon")
        "Tuesday" -> println("Tue")
        "Wednesday" -> println("Wed")
        "Thursday" -> println("Thurs")
        "Friday" -> println("Fri")
        "Saturday" -> println("Sat")
        "Sunday" -> println("Sun")
        else -> println("Enter Proper Day")
    }
}